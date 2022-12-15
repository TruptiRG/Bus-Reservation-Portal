package com.bus.implimentation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bus.exception.FeedbackException;
import com.bus.model.Feedback;
import com.bus.service.FeedbackService;


@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	
	
	@Override
	public Feedback  addFeedBack(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Feedback updateFeedback(Feedback feedback) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedBack(Feedback feedback) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedBack() throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

}
