package it.coachly.api.service.muscle.data;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.model.muscle.QContractionType;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ContractionTypeDto {

    private UUID id;
    private String code;
    private Map<String, String> nameI18n;
    private Map<String, String> descriptionI18n;

    @QueryProjection
    public ContractionTypeDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n) {
        this.id = id;
        this.code = code;
        this.nameI18n = nameI18n;
        this.descriptionI18n = descriptionI18n;
    }

    public static QContractionTypeDto getProjection() {
        QContractionType qCT = QContractionType.contractionType;
        return new QContractionTypeDto(
                qCT.id,
                qCT.code,
                qCT.nameI18n,
                qCT.descriptionI18n
        );
    }
}
