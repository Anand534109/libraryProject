package library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@RestController
@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> error(Exception ex) {
		return ResponseEntity.badRequest().body(ex); 
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeError(RuntimeException rx){
		return ResponseEntity.badRequest().body(rx.getMessage());
	}
}
