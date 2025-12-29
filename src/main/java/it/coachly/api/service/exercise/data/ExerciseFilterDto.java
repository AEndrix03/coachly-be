package it.coachly.api.service.exercise.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseFilterDto {

    private String textFilter;
    private String langFilter;
    private String difficultyLevel;
    private String mechanicsType;
    private String forceType;
    private String isUnilateral;
    private String isBodyweight;
    private String categoryIds;
    private String muscleIds;

    @Builder.Default
    private Integer offset = 0;

    @Builder.Default
    private Integer limit = 10;

}
