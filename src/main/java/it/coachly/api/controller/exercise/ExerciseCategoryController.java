package it.coachly.api.controller.exercise;

import it.coachly.api.service.exercise.component.category.ExerciseCategoryService;
import it.coachly.api.service.exercise.data.component.category.save.ExerciseCategorySaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/category")
@RequiredArgsConstructor
public class ExerciseCategoryController {
    private final ExerciseCategoryService exerciseCategoryService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseCategorySaveDto dto) {
        return ResponseEntity.ok(exerciseCategoryService.save(dto));
    }

    @PatchMapping("/all")
    public ResponseEntity<List<UUID>> saveAll(@RequestBody @Valid List<ExerciseCategorySaveDto> dtos) {
        return ResponseEntity.ok(exerciseCategoryService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
