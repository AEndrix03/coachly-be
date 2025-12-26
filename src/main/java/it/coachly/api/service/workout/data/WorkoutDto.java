package it.coachly.api.service.workout.data;


import it.coachly.api.service.tag.data.TagDto;
import it.coachly.api.service.workout.data.exercise.WorkoutExerciseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {

    private UUID id;
    private Map<String, Object> titleI18n;
    private Map<String, Object> descriptionI18n;

    private UUID coachId;
    private String coachName;

    private BigDecimal progress;
    private Integer exercises;
    private Integer durationMinutes;

    private String goal;

    private LocalDateTime lastUsed;

    private List<TagDto> muscleTags;
    private Integer sessionCount;
    private Integer lastSessionDays;
    private String type;
    private List<WorkoutExerciseDto> workoutExercises;

    private Boolean active;

}
