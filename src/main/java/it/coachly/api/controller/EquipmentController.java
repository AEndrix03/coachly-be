package it.coachly.api.controller;

import it.coachly.api.service.equipment.EquipmentService;
import it.coachly.api.service.equipment.data.save.EquipmentSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid EquipmentSaveDto dto) {
        return ResponseEntity.ok(equipmentService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        equipmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

