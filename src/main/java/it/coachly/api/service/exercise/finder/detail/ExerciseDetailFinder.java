package it.coachly.api.service.exercise.finder.detail;

import com.fasterxml.jackson.core.type.TypeReference;
import it.coachly.api.config.JsonMapper;
import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.ExerciseFilterDto;
import it.coachly.api.service.exercise.data.component.category.ExerciseCategoryDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.component.equipment.ExerciseEquipmentDto;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.component.muscle.ExerciseMuscleDto;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.tag.data.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseDetailFinder {

    private final ExerciseRepository exerciseRepository;
    private final JsonMapper jsonMapper;

    public ExerciseDetailDto findDetailById(UUID exerciseId) {
        Object[] row = exerciseRepository.findDetailById(exerciseId);
        return mapToDetailDto(row);
    }

    public List<ExerciseDetailDto> findDetailsByFilter(ExerciseFilterDto filter) {
        UUID[] categoryIds = parseUUIDs(filter.getCategoryIds());
        UUID[] muscleIds = parseUUIDs(filter.getMuscleIds());

        List<Object[]> results = exerciseRepository.findDetailsByFilter(
                filter.getTextFilter(),
                filter.getLangFilter(),
                filter.getDifficultyLevel(),
                filter.getMechanicsType(),
                filter.getForceType(),
                parseBoolean(filter.getIsUnilateral()),
                parseBoolean(filter.getIsBodyweight()),
                categoryIds,
                muscleIds,
                filter.getOffset() != null ? filter.getOffset() : 0,
                filter.getLimit() != null ? filter.getLimit() : 15
        );

        return results.stream().map(this::mapToDetailDto).toList();
    }

    private ExerciseDetailDto mapToDetailDto(Object[] row) {
        ExerciseDto base = new ExerciseDto(
                (UUID) row[0],
                jsonMapper.parse(row[1], new TypeReference<Map<String, String>>() {
                }),
                jsonMapper.parse(row[2], new TypeReference<Map<String, String>>() {
                }),
                jsonMapper.parse(row[3], new TypeReference<Map<String, String>>() {
                }),
                DifficultyLevelEnum.valueOf((String) row[4]),
                MechanicsTypeEnum.valueOf((String) row[5]),
                row[6] != null ? ForceTypeEnum.valueOf((String) row[6]) : null,
                (Boolean) row[7],
                (Boolean) row[8]
        );

        return ExerciseDetailDto.builderDetail()
                .withBaseExercise(base)
                .withEnvironment(jsonMapper.parse(row[9], ExerciseEnvironmentDto.class))
                .withMovementPattern(jsonMapper.parse(row[10], ExerciseMovementPatternDto.class))
                .withSafety(jsonMapper.parseList(row[11], ExerciseSafetyDto.class))
                .withInstructions(jsonMapper.parseList(row[12], ExerciseInstructionDto.class))
                .withVariants(jsonMapper.parseList(row[13], ExerciseVariantDto.class))
                .withMedia(jsonMapper.parseList(row[14], ExerciseMediaDto.class))
                .withSafetyContraindications(jsonMapper.parseList(row[15], ExerciseSafetyContraindicationDto.class))
                .withCategories(jsonMapper.parseList(row[16], ExerciseCategoryDto.class))
                .withMuscles(jsonMapper.parseList(row[17], ExerciseMuscleDto.class))
                .withEquipments(jsonMapper.parseList(row[18], ExerciseEquipmentDto.class))
                .withTags(jsonMapper.parseList(row[19], TagDto.class))
                .build();
    }

    private Boolean parseBoolean(String value) {
        return value != null ? Boolean.valueOf(value) : null;
    }

    private UUID[] parseUUIDs(String csvIds) {
        if (StringUtils.hasText(csvIds)) return null;
        return Arrays.stream(csvIds.split(","))
                .map(String::trim)
                .map(UUID::fromString)
                .toArray(UUID[]::new);
    }
}