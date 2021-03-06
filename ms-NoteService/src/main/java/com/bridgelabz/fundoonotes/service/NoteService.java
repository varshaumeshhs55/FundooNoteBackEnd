
package com.bridgelabz.fundoonotes.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundoonotes.model.Note;

public interface NoteService{
   
    Note createNote(String token,Note note, HttpServletRequest request) ;
   
    Note updateNote(String token,Note note,int noteId, HttpServletRequest request);
   
    Note deleteNote(String token,int id,HttpServletRequest request);
   
    List<Note> retrieveNote(String token,HttpServletRequest request);

	Note getNoteByNoteId(int noteId);

	void saveNote(Note note);

	Note getNoteByUserId(int id);

}

