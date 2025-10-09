package it.coachly.api.config.generator;

import com.squareup.javapoet.*;
import jakarta.persistence.*;
import org.reflections.Reflections;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

public class RepositoryGenerator {

    public static void main(String[] args) throws IOException {
        String entityPackage = args[0];
        String repoPackage = args[1];

        Reflections reflections = new Reflections(entityPackage);
        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);

        System.out.println("Found " + entities.size() + " entities");

        int generated = 0, skipped = 0;

        for (Class<?> entity : entities) {
            try {
                if (generateRepository(entity, entityPackage, repoPackage)) {
                    generated++;
                    System.out.println("✓ Generated repository for " + entity.getSimpleName());
                } else {
                    skipped++;
                    System.out.println("⊘ Skipped " + entity.getSimpleName() + " (already exists)");
                }
            } catch (Exception e) {
                System.err.println("✗ Failed for " + entity.getSimpleName() + ": " + e.getMessage());
            }
        }

        System.out.println("\nSummary: " + generated + " generated, " + skipped + " skipped");
    }

    private static boolean generateRepository(Class<?> entity, String entityPackage, String repoPackage) throws IOException {
        String repoName = entity.getSimpleName() + "Repository";

        // Estrai il sub-package dalla entity
        String entityFullPackage = entity.getPackageName();
        String subPackage = "";

        if (entityFullPackage.startsWith(entityPackage + ".")) {
            subPackage = entityFullPackage.substring(entityPackage.length() + 1);
        }

        // Costruisci il package del repository mantenendo la struttura
        String targetRepoPackage = subPackage.isEmpty()
                ? repoPackage
                : repoPackage + "." + subPackage;

        // Controlla se esiste già
        Path repoPath = Paths.get("src/main/java",
                targetRepoPackage.replace('.', '/'),
                repoName + ".java");

        if (Files.exists(repoPath)) {
            return false; // Skip
        }

        // Crea le directory se non esistono
        Files.createDirectories(repoPath.getParent());

        // Trova il tipo dell'ID
        Class<?> idType = findIdType(entity)
                .orElseThrow(() -> new IllegalStateException(
                        "No @Id or @EmbeddedId found in entity " + entity.getSimpleName()
                ));

        TypeSpec repository = TypeSpec.interfaceBuilder(repoName)
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(
                        ClassName.get("org.springframework.data.jpa.repository", "JpaRepository"),
                        ClassName.get(entity),
                        ClassName.get(idType)
                ))
                .addSuperinterface(ParameterizedTypeName.get(
                        ClassName.get("org.springframework.data.querydsl", "QuerydslPredicateExecutor"),
                        ClassName.get(entity)
                ))
                .build();

        JavaFile javaFile = JavaFile.builder(targetRepoPackage, repository)
                .indent("    ")
                .build();

        javaFile.writeTo(new File("src/main/java"));
        return true;
    }

    private static Optional<Class<?>> findIdType(Class<?> entity) {
        // Cerca @Id
        for (Field field : entity.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                return Optional.of(field.getType());
            }
        }

        // Cerca @EmbeddedId
        for (Field field : entity.getDeclaredFields()) {
            if (field.isAnnotationPresent(EmbeddedId.class)) {
                return Optional.of(field.getType());
            }
        }

        // Risali nella gerarchia
        Class<?> superclass = entity.getSuperclass();
        if (superclass != null && superclass.isAnnotationPresent(Entity.class)) {
            return findIdType(superclass);
        }

        return Optional.empty();
    }
}