package com.snkit.restversionadvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DemoAdvice {
	
	@Autowired
	LogConsoleHandler logConsoleHandler;
	
	@Autowired
	RetryHandler retryHandler;
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<Object> handleException(HttpMediaTypeNotSupportedException ex, WebRequest request) {
		
		System.out.println("   From custom advice ::::::::::::::::::::::::");  
		
		AppError error = new AppError();
		error.setErrorType("W");
		error.setCode("415");
		error.setMsg("Given content type is not supported by applicaiton");
		
		return new ResponseEntity<>(error,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		
		
	}

	@ExceptionHandler(DemoException.class)
	public ResponseEntity<Object> handleException(DemoException ex, WebRequest request) {
		
		System.out.println("   From custom advice :::::::::::DemoException:::::::::::::");  
		
	
		retryHandler.handle(ex);
		
		AppError error = new AppError();
		error.setErrorType("E");
		error.setCode(ex.getCorelationid());
		error.setMsg(ex.getMsg());
		
		
		
		return new ResponseEntity<>(error,HttpStatus.OK);
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		
		System.out.println("   From custom advice :::::::::::Exception:::::::::::::");  
		
		AppError error = new AppError();
		error.setErrorType("E");
		error.setCode("GOO1");
		error.setMsg("Error occurred please contact support");
		
		logConsoleHandler.handle(ex);
		
		return new ResponseEntity<>(error,HttpStatus.OK);
		
		
	}
	
	
}
