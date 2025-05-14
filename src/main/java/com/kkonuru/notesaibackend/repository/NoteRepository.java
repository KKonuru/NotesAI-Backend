package com.kkonuru.notesaibackend.repository;

import com.kkonuru.notesaibackend.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository  extends MongoRepository<Note,String> {


    Optional<List<Note>> findByUserId(String userId);
}
