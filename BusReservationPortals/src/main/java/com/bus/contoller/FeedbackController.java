package com.bus.contoller;

import com.bus.exception.BusException;
import com.bus.exception.FeedbackException;
import com.bus.exception.UserException;
import com.bus.implementation.FeedbackServiceImpl;
import com.bus.model.Feedback;
import com.bus.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackServiceImpl fservice;

    @PostMapping("/add/{busId}")
    public ResponseEntity<Feedback> addFeedbackHandler( @PathVariable("busId") Integer busId,@Valid @RequestBody Feedback feedback,@RequestParam String key) throws FeedbackException, UserException, BusException, BusException {

        Feedback f = fservice.addFeedback( busId, feedback,key);

        return new ResponseEntity<Feedback>(f, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Feedback> updateFeedbackHandler( @Valid @RequestBody Feedback feedback,@RequestParam String key) throws FeedbackException,UserException{

        Feedback f = fservice.updateFeedback(feedback,key);

        return new ResponseEntity<Feedback>(f, HttpStatus.ACCEPTED);

    }

    @GetMapping("/view/{feedbackId}")
    public ResponseEntity<Feedback> viewFeedbackHandler(@PathVariable("feedbackId") Integer feedbackId,@RequestParam String key) throws FeedbackException,UserException{

        Feedback f = fservice.viewFeedback(feedbackId,key);

        return new ResponseEntity<Feedback>(f, HttpStatus.FOUND);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Feedback>> viewAllFeedbackHandler(@RequestParam String key) throws FeedbackException,UserException{

        List<Feedback> f = fservice.viewAllFeedback(key);

        return new ResponseEntity<List<Feedback>>(f, HttpStatus.FOUND);
    }
}
