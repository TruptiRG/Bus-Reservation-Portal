package com.bus.service;

import java.util.List;

import com.bus.exception.FeedbackException;
import com.bus.model.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedBack(Feedback feedback) ;
	
	public Feedback updateFeedback(Feedback feedback)throws FeedbackException;
	
	public Feedback viewFeedBack(Feedback feedback)throws FeedbackException;
	
	public List<Feedback> viewAllFeedBack()throws FeedbackException;
}
