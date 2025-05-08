package com.kkonuru.notesaibackend.service;


import com.kkonuru.notesaibackend.model.Note;
import com.kkonuru.notesaibackend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NoteService {

    private final NoteRepository noteRepository;
    public NoteService(@Autowired NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
    public String save(Note note) {
        return noteRepository.save(note).getId();
    }

    public Note getNote(String id,String user_id) {
        Optional<Note> response = noteRepository.findByIdAndUserId(id,user_id);
        return response.orElse(null);
    }
}