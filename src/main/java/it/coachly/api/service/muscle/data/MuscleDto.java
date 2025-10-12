package it.coachly.api.service.muscle.data;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.muscle.MuscleGroupEnum;
import it.coachly.api.enums.muscle.MuscleSubgroupEnum;
import it.coachly.api.model.muscle.QMuscle;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class MuscleDto {

    private UUID id;
    private String code;
    private Map<String, String> nameI18n;
    private Map<String, String> descriptionI18n;
    private MuscleGroupEnum muscleGroup;
    private MuscleSubgroupEnum muscleSubgroup;
    private String anatomicalName;

    @QueryProjection
    public MuscleDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, MuscleGroupEnum muscleGroup, MuscleSubgroupEnum muscleSubgroup, String anatomicalName) {
        this.id = id;
        this.code = code;
        this.nameI18n = nameI18n;
        this.descriptionI18n = descriptionI18n;
        this.muscleGroup = muscleGroup;
        this.muscleSubgroup = muscleSubgroup;
        this.anatomicalName = anatomicalName;
    }

    public static QMuscleDto getProjection() {
        QMuscle qM = QMuscle.muscle;
        return new QMuscleDto(
                qM.id,
                qM.code,
                qM.nameI18n,
                qM.descriptionI18n,
                qM.muscleGroup,
                qM.muscleSubgroup,
                qM.anatomicalName
        );
    }
}
