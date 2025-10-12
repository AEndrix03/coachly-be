package it.coachly.api.service.tag.data.save;

import it.coachly.api.enums.tag.TagTypeEnum;
import it.coachly.api.service.tag.data.TagDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class TagSaveDto extends TagDto {

    private Boolean isActive;

    public TagSaveDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, TagTypeEnum tagType, Boolean isActive) {
        super(id, code, nameI18n, descriptionI18n, tagType);
        this.isActive = isActive;
    }
}
