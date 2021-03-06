package com.bridgelabz.fundoonotes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Utility.TokenGenerator;
import com.bridgelabz.fundoonotes.dao.LabelRepository;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.model.Note;

@Service
public class LabelServiceImpl implements LabelService {
	

	    @Autowired
	    private LabelRepository labelRepository;

	    @Autowired
	    private TokenGenerator tokenGenerator;
	   
	    @Autowired
	    private NoteService noteService;

	    public Label createLabel(String token,Label label, HttpServletRequest request){
	        int id=tokenGenerator.authenticateToken(token);
	        if(id>0) {
	            label.setUserId(id);
	            Label newLabel=labelRepository.save(label);
	            return newLabel;
	        }
	        return null;
	    }

	    public Label updateLabel(String token,Label label, HttpServletRequest request)
	    {
	        int id=tokenGenerator.authenticateToken(token);
	        Label newLabel=labelRepository.findByUserId(id);
	        if(newLabel!=null) {
	        	newLabel.setLabelName(label.getLabelName());
	            return labelRepository.save(newLabel);
	        }
	        return newLabel;
	    }

	    public List<Label> retrieveLabel(String token, HttpServletRequest request) {
	        int id=tokenGenerator.authenticateToken(token);
	        List<Label> labels = labelRepository.findAllByUserId(id);
	        if (!labels.isEmpty())
	            return labels;
	        else
	            return null;
	    }
	    @Transactional
	    public boolean deleteLabel(String token, HttpServletRequest request) {
	        int id=tokenGenerator.authenticateToken(token);
	        Label newLabel=labelRepository.findByUserId(id);
	        if(newLabel!=null) {
	            labelRepository.deleteAllByUserId(id);
	            return true;
	        }
	        else
	            return false;
	    }
	    public boolean mapNoteToLabel(String token, int noteId, int labelId) {
	        int id= tokenGenerator.authenticateToken(token);
	        Note note = noteService.getNoteByUserId(id);
	        Label label=labelRepository.findByLabelId(labelId);
	        List<Label> labels = labelRepository.findAllByUserId(id);
	        labels.add(label);
	        if (!labels.isEmpty()) {
	            note.setLabelList(labels);
	            noteService.saveNote(note);
	            //labelRepository.save(label);
	            return true;
	        }
	        return false;
	    }

		@Override
		public boolean removeNoteLabel(String token, int noteId, int labelId) {
		        int id = tokenGenerator.authenticateToken(token);
		        Note newNote = noteService.getNoteByNoteId(noteId);
		        List<Label> labels = newNote.getLabelList();
		        if (!labels.isEmpty()) {
		            labels = labels.stream().filter(label -> label.getId() != labelId)
		                    .collect(Collectors.toList());
		            newNote.setLabelList(labels);
		            labelRepository.deleteAll(labels);
		            return true;
		        }
		        return false;
		    }
		
		}
	    

