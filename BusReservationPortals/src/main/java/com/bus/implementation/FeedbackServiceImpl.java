package com.bus.implementation;

import com.bus.exception.BusException;
import com.bus.exception.FeedbackException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.model.CurrentSession;
import com.bus.model.Feedback;
import com.bus.model.User;
import com.bus.repository.BusRepo;
import com.bus.repository.FeedbackRepo;
import com.bus.repository.SessionRepo;
import com.bus.repository.UserRepo;
import com.bus.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepo fRepo;

    @Autowired
    private UserRepo uRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private SessionRepo srepo;

    @Override
    public Feedback addFeedback( Integer busId, Feedback feedback,String key) throws FeedbackException, UserException, BusException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to update user");
        }
        User user = uRepo.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
        if(user.getUserLoginId()==loggedInUser.getUserId()) {
            Bus b = busRepo.findById(busId).orElseThrow(() -> new BusException("Bus with Id " + busId + " not found"));

            feedback.setBus(b);
            feedback.setUser(user);

            Feedback f = fRepo.save(feedback);

            return f;
        }else throw new UserException("Invalid User Id");



    }

    @Override
    public Feedback updateFeedback( Feedback feedback,String key) throws FeedbackException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to update user");
        }
        User user = uRepo.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
        if(user.getUserLoginId()==loggedInUser.getUserId()) {
            Feedback f = fRepo.findById(feedback.getFeedBackId()).orElseThrow(() -> new FeedbackException("Feedback with Id " + feedback.getFeedBackId() + " does not exist"));

            if (feedback.getComment() != null) f.setComment(feedback.getComment());
            if (feedback.getDriverRating() != null) f.setDriverRating(feedback.getDriverRating());
            if (feedback.getServiceRating() != null) f.setServiceRating(feedback.getServiceRating());
            if (feedback.getOverAllRating() != null) f.setOverAllRating(feedback.getOverAllRating());

            Feedback updated = fRepo.save(f);

            return updated;
        }else throw new UserException("Invalid User Id");

    }

    @Override
    public Feedback viewFeedback(Integer feedbackId, String key) throws FeedbackException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to update user");
        }
        User user = uRepo.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
        if(user.getUserLoginId()==loggedInUser.getUserId()) {
            Feedback f = fRepo.findById(feedbackId).orElseThrow(() -> new FeedbackException("Feedback with Id " + feedbackId + " does not exist"));
            return f;
        }else throw new UserException("Invalid User Id");

    }

    @Override
    public List<Feedback> viewAllFeedback(String key) throws FeedbackException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to update user");
        }
        User user = uRepo.findById(loggedInUser.getUserId()).orElseThrow(() -> new UserException("User with Id " + loggedInUser.getUserId() + " not found"));
        if(user.getUserLoginId()==loggedInUser.getUserId()) {
            List<Feedback> f= fRepo.findAll();

            if (!f.isEmpty()) return f;
            else throw new FeedbackException("Feedback not found");
        }else throw new UserException("Invalid User Id");

    }

}
