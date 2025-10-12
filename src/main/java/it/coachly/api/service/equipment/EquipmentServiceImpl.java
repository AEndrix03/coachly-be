package it.coachly.api.service.equipment;

import it.coachly.api.repository.equipment.EquipmentRepository;
import it.coachly.api.service.equipment.data.save.EquipmentSaveDto;
import it.coachly.api.service.equipment.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    private final EquipmentMapper equipmentMapper;

    @Override
    public UUID save(EquipmentSaveDto equipment) {
        return equipmentRepository.save(this.equipmentMapper.toEntity(equipment)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        equipmentRepository.deleteById(id);
    }

}
