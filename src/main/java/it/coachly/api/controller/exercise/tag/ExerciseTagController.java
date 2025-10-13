package it.coachly.api.controller.exercise.tag;

import it.coachly.api.service.exercise.component.tag.ExerciseTagService;
import it.coachly.api.service.exercise.data.component.tag.save.ExerciseTagSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/tag")
@RequiredArgsConstructor
public class ExerciseTagController {
    private final ExerciseTagService exerciseTagService;

    @PatchMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ExerciseTagSaveDto dto) {
        exerciseTagService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/all")
    public ResponseEntity<Void> saveAll(@RequestBody @Valid List<ExerciseTagSaveDto> dtos) {
        exerciseTagService.saveAll(dtos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam UUID exerciseId, @RequestParam UUID tagId) {
        exerciseTagService.deleteById(exerciseId, tagId);
        return ResponseEntity.noContent().build();
    }
}
