package com.kkonuru.notesaibackend.service;


import com.kkonuru.notesaibackend.model.Note;
import com.kkonuru.notesaibackend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public List<Note> getNotes(String user_id) {
        Optional<List<Note>> response = noteRepository.findByUserId(user_id);
        return response.orElse(null);
    }
}