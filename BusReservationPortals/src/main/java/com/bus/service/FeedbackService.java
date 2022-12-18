package com.bus.service;

import com.bus.exception.BusException;
import com.bus.exception.FeedbackException;
import com.bus.exception.UserException;
import com.bus.model.Feedback;

import java.util.List;

public interface FeedbackService {

    public Feedback addFeedback( Integer busId, Feedback feedback,String key) throws FeedbackException, UserException, BusException;

    public Feedback updateFeedback(Feedback feedback,String key) throws FeedbackException,UserException;

    public Feedback viewFeedback(Integer feedbackId, String key) throws FeedbackException,UserException;

    public List<Feedback> viewAllFeedback(String key) throws FeedbackException,UserException;
}
