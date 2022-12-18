package com.bus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException se, WebRequest req){


		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);

	}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){


        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(BusException.class)
    public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException se, WebRequest req){


        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<MyErrorDetails> reservationExceptionHandler(ReservationException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RouteException.class)
    public ResponseEntity<MyErrorDetails> routeExceptionHandler(RouteException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FeedbackException.class)
    public ResponseEntity<MyErrorDetails> feedbackExceptionHandler(FeedbackException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
