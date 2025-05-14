package com.kkonuru.notesaibackend.controller;

import com.kkonuru.notesaibackend.auth.ClerkAuthService;
import com.kkonuru.notesaibackend.model.Note;
import com.kkonuru.notesaibackend.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "http://localhost:3000",
        allowCredentials = "true",
        allowedHeaders = "*",
        exposedHeaders = "Authorization")
public class NoteController {
    private final NoteService noteService;
    private final ClerkAuthService clerkAuthService;
    public NoteController(@Autowired NoteService noteService,@Autowired ClerkAuthService clerkAuthService) {
        this.noteService = noteService;
        this.clerkAuthService = clerkAuthService;
    }


    @PostMapping
    public String save(@Valid @RequestBody Note note, HttpServletRequest request) {
        String userId = clerkAuthService.getUserIdFromToken(request);
        System.out.println("user id is " + userId);
        note.setUserId(userId);
        return this.noteService.save(note);
    }


    @GetMapping
    public List<Note> getNotes(HttpServletRequest request) {
       String userId = clerkAuthService.getUserIdFromToken(request);
        // You can now use userId as needed (e.g., for authorization)
        return this.noteService.getNotes(userId);
    }
}
