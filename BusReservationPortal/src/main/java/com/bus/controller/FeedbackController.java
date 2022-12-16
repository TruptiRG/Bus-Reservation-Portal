package com.bus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.model.Feedback;
import com.bus.service.FeedbackService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService fservice;
	
	@PostMapping("/feedbacks")
	public ResponseEntity<Feedback> saveUserFeedback(@Valid @RequestBody  Feedback feed){
		Feedback feeds=fservice.addFeedBack(feed);
		
		return new ResponseEntity<Feedback>(feeds,HttpStatus.ACCEPTED);
	}
}
