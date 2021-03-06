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
        int id=tokenGenerator.authenticateToken(token);
        note.setUserId(id);
        Note newnote=noteRepository.save(note);
        return newnote;
    }

    @Override
    public Note updateNote(String token, Note note,int noteId ,HttpServletRequest request) {
        int id=tokenGenerator.authenticateToken(token);
        Note newNote=noteRepository.getOne(noteId);
        if(newNote!=null) {
            newNote.setUserId(id);
            newNote.setDiscription(note.getDiscription());
            newNote.setTitle(note.getTitle());
            Note updatedNote=noteRepository.save(newNote);
            return updatedNote;
           
        }
        return null;
    }
    @Override
    public Note deleteNote(String token,int noteId,HttpServletRequest request) {
        int id=tokenGenerator.authenticateToken(token);
        Note newNote=noteRepository.findNoteByUserId(id);
        if(newNote!=null) {
        noteRepository.deleteById(noteId);
        return newNote;
        }
        else
            return null;
    }
    @Override
    public List<Note> retrieveNote(String token,HttpServletRequest request) {
        int id=tokenGenerator.authenticateToken(token);
        List<Note> Notes = noteRepository.findAllNoteByUserId(id);
        if (!Notes.isEmpty()) {
            return Notes;
        }
        return null;
    }

	@Override
	public Note getNoteByNoteId(int noteId) {
		return noteRepository.findNoteByUserId(noteId);
	}

	@Override
	public void saveNote(Note note) {
		// TODO Auto-generated method stub
		noteRepository.save(note);
	}

	@Override
	public Note getNoteByUserId(int id) {
		return noteRepository.findNoteByUserId(id);
	}

}

