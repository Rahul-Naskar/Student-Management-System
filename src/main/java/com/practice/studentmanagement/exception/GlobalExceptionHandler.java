package com.practice.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler
{

    // This will return only the string message but the status code will 200 ok -.

//    @ExceptionHandler(CustomException.class)
//    public String studentNotFound(CustomException customException)
//    {
//        return customException.getMessage();
//    }

    @ExceptionHandler(CustomException.class)
    public ProblemDetail studentNotFound(CustomException customException)
    {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail(customException.getMessage());
        problemDetail.setTitle("This is my custom exception");
        problemDetail.setProperty("Time Now", LocalDateTime.now());
        return problemDetail;
    }
}
