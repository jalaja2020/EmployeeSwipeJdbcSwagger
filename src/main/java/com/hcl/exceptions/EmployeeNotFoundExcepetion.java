package com.hcl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundExcepetion  extends RuntimeException {

    public EmployeeNotFoundExcepetion() {
        super();
    }
    public EmployeeNotFoundExcepetion(int id) {
        super("test"+id);
    }

}