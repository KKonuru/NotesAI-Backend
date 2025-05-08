package com.kkonuru.notesaibackend.repository;

import com.kkonuru.notesaibackend.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository  extends MongoRepository<Note,String> {

    Optional<Note> findByIdAndUserId(String id, String userId);
}
