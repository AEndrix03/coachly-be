package it.coachly.api.service.tag.data;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.tag.TagTypeEnum;
import it.coachly.api.model.tag.QTag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class TagDto {

    private UUID id;
    private String code;
    private Map<String, String> nameI18n;
    private Map<String, String> descriptionI18n;
    private TagTypeEnum tagType;

    @QueryProjection
    public TagDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, TagTypeEnum tagType) {
        this.id = id;
        this.code = code;
        this.nameI18n = nameI18n;
        this.descriptionI18n = descriptionI18n;
        this.tagType = tagType;
    }

    public static QTagDto getProjection() {
        QTag qTag = QTag.tag;
        return new QTagDto(
                qTag.id,
                qTag.code,
                qTag.nameI18n,
                qTag.descriptionI18n,
                qTag.tagType
        );
    }

}
