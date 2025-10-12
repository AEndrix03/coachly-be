package it.coachly.api.service.exercise.component.equipment;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.equipment.equipment.ExerciseEquipmentRepository;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.component.equipment.save.ExerciseEquipmentSaveDto;
import it.coachly.api.service.exercise.mapper.component.equipment.ExerciseEquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseEquipmentServiceImpl implements ExerciseEquipmentService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseEquipmentRepository exerciseEquipmentRepository;
    private final ExerciseEquipmentMapper exerciseEquipmentMapper;

    @Override
    public UUID save(ExerciseEquipmentSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseEquipmentRepository.save(exerciseEquipmentMapper.toEntity(dto)).getId();
    }

    @Override
    public List<UUID> saveAll(List<ExerciseEquipmentSaveDto> dtos) {
        return dtos.stream().map(this::save).toList();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseEquipmentRepository.deleteById(id);
    }
}

