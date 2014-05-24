package com.mumoo.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mumoo.exceptions.BadParamException;
import com.mumoo.exceptions.ErrorException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(BadParamException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody
	String handleBadParameterException(BadParamException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(ErrorException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	String handleErrorException(ErrorException e) {
		return e.getMessage();
	}
}
