package com.scalar.taskmanager.controllers;

import com.scalar.taskmanager.dto.CreateNoteDTO;
import com.scalar.taskmanager.dto.CreateNoteResponseDTO;
import com.scalar.taskmanager.entities.NoteEntity;
import com.scalar.taskmanager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks/{taskId}/notes")
public class NotesCotroller {

    private final NoteService noteService;

    public NotesCotroller(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId) {
        List<NoteEntity> notes = noteService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Integer taskId,
            @RequestBody CreateNoteDTO createNoteDTO
    ) {
        NoteEntity noteEntity = noteService.addNoteForTask(taskId, createNoteDTO.getTitle(), createNoteDTO.getBody());
        CreateNoteResponseDTO response = new CreateNoteResponseDTO();
        response.setTasksId(taskId);
        response.setNote(noteEntity);
        return ResponseEntity.ok(response);
    }
}
