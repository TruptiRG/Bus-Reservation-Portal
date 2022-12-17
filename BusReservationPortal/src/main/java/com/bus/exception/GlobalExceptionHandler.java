<<<<<<< HEAD
package com.bus.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bus.model.Reservation;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception me, WebRequest re){
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<MyErrorDetails> myIllegalArgumentExceptionHandler(IllegalArgumentException iae,
			WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(iae.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}
	public ResponseEntity<MyErrorDetails> MethodNotValidException(MethodArgumentNotValidException mexc){
		        MyErrorDetails error = new MyErrorDetails();
				error.setTime(LocalDateTime.now());
				error.setMessage("Validation Error");
				error.setDescription(mexc.getBindingResult().getFieldError().getDefaultMessage());
				return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<MyErrorDetails> BusException(BusException bus,WebRequest req){
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTime(LocalDateTime.now());
		error.setMessage(bus.getMessage());
		error.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<MyErrorDetails> UserException(UserException user,WebRequest req){
		MyErrorDetails error = new MyErrorDetails();

		error.setTime(LocalDateTime.now());
		error.setMessage(user.getMessage());
		error.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<MyErrorDetails> ReservationException(ReservationException reservation, WebRequest req){
		MyErrorDetails error = new MyErrorDetails();
		error.setTime(LocalDateTime.now());
		error.setMessage(reservation.getMessage());
		error.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

	
	public ResponseEntity<MyErrorDetails> FeedbackException(FeedbackException feedback,WebRequest req){
		MyErrorDetails error = new MyErrorDetails();

		error.setTime(LocalDateTime.now());
		error.setMessage(feedback.getMessage());
		error.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	
public ResponseEntity<MyErrorDetails> LoginException(LoginException login,WebRequest req){
		MyErrorDetails error = new MyErrorDetails();

		error.setTime(LocalDateTime.now());
		error.setMessage(login.getMessage());
		error.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

}
=======

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
}
>>>>>>> c4617b6ed8acc37a889649209520783e6544f81a
