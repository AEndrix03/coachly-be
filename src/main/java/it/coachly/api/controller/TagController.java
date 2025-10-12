package it.coachly.api.controller;

import it.coachly.api.service.tag.TagService;
import it.coachly.api.service.tag.data.save.TagSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid TagSaveDto dto) {
        return ResponseEntity.ok(tagService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
