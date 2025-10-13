package it.coachly.api.controller.exercise.media;

import it.coachly.api.service.exercise.component.media.ExerciseMediaService;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.component.media.save.ExerciseMediaSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/media")
@RequiredArgsConstructor
public class ExerciseMediaController {
    private final ExerciseMediaService exerciseMediaService;

    @GetMapping("/{exerciseId}")
    public ResponseEntity<List<ExerciseMediaDto>> getByExercise(@PathVariable UUID exerciseId) {
        return ResponseEntity.ok(exerciseMediaService.getExerciseMedia(exerciseId));
    }

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseMediaSaveDto dto) {
        return ResponseEntity.ok(exerciseMediaService.save(dto));
    }

    @PatchMapping("/all")
    public ResponseEntity<List<UUID>> saveAll(@RequestBody @Valid List<ExerciseMediaSaveDto> dtos) {
        return ResponseEntity.ok(exerciseMediaService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseMediaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
