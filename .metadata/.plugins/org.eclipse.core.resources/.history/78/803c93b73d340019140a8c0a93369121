package com.bridgelabz.fundoonotes.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Utility.TokenGenerator;
import com.bridgelabz.fundoonotes.dao.NoteRepository;
import com.bridgelabz.fundoonotes.model.Note;


@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Override
    public Note createNote(String token, Note note, HttpServletRequest request) {
        int userId=tokenGenerator.authenticateToken(token);
        note.setUserId(userId);
        Note savedNote=noteRepository.save(note);
        return savedNote;
    }

    @Override
    public Note editNote(String token, Note note,int noteId ,HttpServletRequest request) {
        int userId=tokenGenerator.authenticateToken(token);
        Note existingNote=noteRepository.getOne(noteId);
        if(existingNote!=null) {
            existingNote.setUserId(userId);
            existingNote.setDiscription(note.getDiscription());
            existingNote.setTitle(note.getTitle());
            Note updatedNote=noteRepository.save(existingNote);
            return updatedNote;
           
        }
        return null;
    }
    @Override
    public Note deleteNote(String token,int noteId,HttpServletRequest request) {
        int userId=tokenGenerator.authenticateToken(token);
        Note aliveNote=noteRepository.findNoteByUserId(userId);
        if(aliveNote!=null) {
        noteRepository.deleteById(noteId);
        return aliveNote;
        }
        else
            return null;
    }
    @Override
    public List<Note> retrieveNote(String token,HttpServletRequest request) {
        int userId=tokenGenerator.authenticateToken(token);
        List<Note> Notes = noteRepository.findAllNoteByUserId(userId);
        if (!Notes.isEmpty()) {
            return Notes;
        }
        return null;
    }

}

