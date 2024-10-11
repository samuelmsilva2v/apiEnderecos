package com.example.demo.infrastructure.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BeanValidationConfig {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public List<String> errorHandler(MethodArgumentNotValidException e) {

		List<String> errors = new ArrayList<String>();

		for (FieldError error : e.getBindingResult().getFieldErrors())
			errors.add(error.getField() + " : " + error.getDefaultMessage());

		for (ObjectError error : e.getBindingResult().getGlobalErrors())
			errors.add(error.getObjectName() + " : " + error.getDefaultMessage());

		return errors;
	}

}