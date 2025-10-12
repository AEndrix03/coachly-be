package it.coachly.api.service.tag;

import it.coachly.api.repository.tag.TagRepository;
import it.coachly.api.service.tag.data.save.TagSaveDto;
import it.coachly.api.service.tag.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    @Override
    public UUID save(TagSaveDto dto) {
        return tagRepository.save(tagMapper.toEntity(dto)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        tagRepository.deleteById(id);
    }

}
