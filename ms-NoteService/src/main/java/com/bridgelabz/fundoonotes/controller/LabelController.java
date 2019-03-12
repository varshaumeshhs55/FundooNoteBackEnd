package com.bridgelabz.fundoonotes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.service.LabelService;

@Controller
@RequestMapping("/user")
public class LabelController {
	
	    @Autowired
	    private LabelService labelService;

	    @PostMapping("/createlabel")
	    public ResponseEntity<?> createLabel(@RequestHeader ("token")String token,@RequestBody Label label, HttpServletRequest request,HttpServletResponse response) {       
	        if (labelService.createLabel(token,label, request)!=null)
	            return new ResponseEntity<String>("label Succesfully Created",HttpStatus.OK);
	        else
	            return new ResponseEntity<String>("pls provide details correctly",HttpStatus.CONFLICT);
	    }
	   
	    @PutMapping("/updatelabel")
	    public ResponseEntity<?> updateLabel(@RequestHeader ("token")String token,@RequestBody Label label, HttpServletRequest request,HttpServletResponse response) {       
	        if (labelService.updateLabel(token,label, request)!=null)
	            return new ResponseEntity<String>("label Succesfully updated",HttpStatus.OK);
	        else
	            return new ResponseEntity<String>("pls provide details correctly",HttpStatus.CONFLICT);
	    }
	   
	    @GetMapping("/retrievelabel")
	    public ResponseEntity<?> retrieveLabel(@RequestHeader ("token")String token, HttpServletRequest request,HttpServletResponse response) {       
	       
	        List<Label> labels=labelService.retrieveLabel(token, request);
	        if (labels!=null)
	            return new ResponseEntity<List<Label>>(labels,HttpStatus.OK);
	        else
	            return new ResponseEntity<String>("pls provide details correctly",HttpStatus.CONFLICT);
	    }
	   
	    @PostMapping("/deletelabel")
	    public ResponseEntity<?> deletelabel(@RequestHeader ("token")String token,HttpServletRequest request) {       
	       
	        if(labelService.deleteLabel(token, request))
	            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
	        else
	            return new ResponseEntity<String>("pls provide details correctly",HttpStatus.CONFLICT);
	    }
	   
	    @PostMapping("/mapnote&label")
	    public ResponseEntity<?> mapNoteLabel(@RequestHeader ("token")String token,@RequestParam ("noteId")int noteId,@RequestParam ("labelId")int labelId,HttpServletRequest request) {       

	        if(labelService.mapNoteToLabel(token, noteId, labelId))
	            return new ResponseEntity<>("Mapped successfully",HttpStatus.OK);
	        else
	            return new ResponseEntity<String>("pls provide details correctly",HttpStatus.CONFLICT);
	    }

	    @DeleteMapping("/removenote&label")
	    public ResponseEntity<?> removeNoteLabel(@RequestHeader ("token")String token,@RequestParam ("noteId")int noteId,@RequestParam ("labelId")int labelId,HttpServletRequest request) {       

	        if(labelService.removeNoteLabel(token, noteId, labelId))
	            return new ResponseEntity<>("Labels from particular note has been removed ",HttpStatus.OK);
	        else
	            return new ResponseEntity<String>("pls provide details correctly",HttpStatus.CONFLICT);
	    }
	   
	   

	}


