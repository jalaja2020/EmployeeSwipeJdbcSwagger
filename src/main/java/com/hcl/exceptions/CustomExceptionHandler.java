package com.hcl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmployeeNotFoundExcepetion.class)
	public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse("400","Employee Not Found Exception");
        return new ResponseEntity<CustomErrorResponse>(errors, HttpStatus.NOT_FOUND);

    }


}
