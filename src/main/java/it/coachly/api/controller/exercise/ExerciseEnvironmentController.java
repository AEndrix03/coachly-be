package it.coachly.api.controller.exercise;

import it.coachly.api.service.exercise.component.core.ExerciseEnvironmentService;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseEnvironmentSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/environment")
@RequiredArgsConstructor
public class ExerciseEnvironmentController {
    private final ExerciseEnvironmentService exerciseEnvironmentService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseEnvironmentSaveDto dto) {
        return ResponseEntity.ok(exerciseEnvironmentService.save(dto));
    }
}

