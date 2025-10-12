package it.coachly.api.service.tag;

import it.coachly.api.service.tag.data.save.TagSaveDto;

import java.util.UUID;

public interface TagService {
    UUID save(TagSaveDto dto);

    void deleteById(UUID id);
}
