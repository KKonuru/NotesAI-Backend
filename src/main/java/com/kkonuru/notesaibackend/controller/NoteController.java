package com.kkonuru.notesaibackend.controller;

import com.kkonuru.notesaibackend.auth.ClerkAuthService;
import com.kkonuru.notesaibackend.model.Note;
import com.kkonuru.notesaibackend.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    private final ClerkAuthService clerkAuthService;
    public NoteController(@Autowired NoteService noteService,@Autowired ClerkAuthService clerkAuthService) {
        this.noteService = noteService;
        this.clerkAuthService = clerkAuthService;
    }


    @PostMapping
    public String save(@RequestBody Note note){
        return this.noteService.save(note);
    }

    @GetMapping
    public Note getNote(@RequestParam("id") String id, HttpServletRequest request) {
       String userId = clerkAuthService.getUserIdFromToken(request);
        // You can now use userId as needed (e.g., for authorization)
        return this.noteService.getNote(id, userId);
    }
}
