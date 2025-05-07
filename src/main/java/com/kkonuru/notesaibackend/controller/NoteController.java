package com.kkonuru.notesaibackend.controller;

import com.kkonuru.notesaibackend.model.Note;
import com.kkonuru.notesaibackend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(@Autowired NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping
    public String save(@RequestBody Note note){
        return this.noteService.save(note);
    }

    @GetMapping
    public Note getNote(@RequestParam("id")String id){
        return this.noteService.getNote(id);
    }
}
