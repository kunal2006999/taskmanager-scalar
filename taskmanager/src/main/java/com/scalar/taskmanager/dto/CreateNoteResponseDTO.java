package com.scalar.taskmanager.dto;

import com.scalar.taskmanager.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateNoteResponseDTO {
    private Integer tasksId;
    private NoteEntity note;
}
