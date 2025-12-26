package it.coachly.api.service.workout.data.exercise;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutExerciseDto {

    private ExerciseDetailDto exercise;
    private String sets;
    private String rest;
    private String weight;
    private String progress;

    @QueryProjection
    public WorkoutExerciseDto(ExerciseDetailDto exercise, String sets, String rest, String weight, String progress) {
        this.exercise = exercise;
        this.sets = sets;
        this.rest = rest;
        this.weight = weight;
        this.progress = progress;
    }
}

