package com.skypro.HW8.controller;

import com.skypro.HW8.exception.EmployeeNotFoundException;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({EmployeeNotFoundException.class})
    public void error(Exception e, HttpServletResponse response) throws IOException {
        response.setStatus(404);
        response.getWriter().println("Error: " + e.getMessage());
    }
}
