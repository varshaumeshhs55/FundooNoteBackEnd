package com.bridgelabz.fundoonotes.service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundoonotes.model.Label;


	public interface LabelService{

	    Label createLabel(String token,Label label, HttpServletRequest request);
	   
	    Label updateLabel(String token,Label label, HttpServletRequest request);
	   
	    List<Label> retrieveLabel(String token,HttpServletRequest request);
	   
	    boolean deleteLabel(String token, HttpServletRequest request );
	   
	    public boolean mapNoteToLabel(String token, int noteId, int labelId);

		boolean removeNoteLabel(String token, int noteId, int labelId);
	}



