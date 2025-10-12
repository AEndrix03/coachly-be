package it.coachly.api.service.tag.mapper;

import it.coachly.api.model.tag.Tag;
import it.coachly.api.service.tag.data.save.TagSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class TagMapper implements IEntityMapper<TagSaveDto, Tag> {

    public Tag toEntity(TagSaveDto dto) {
        return Tag.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .nameI18n(dto.getNameI18n())
                .descriptionI18n(dto.getDescriptionI18n())
                .isActive(dto.getIsActive())
                .build();
    }

}
