package com.crio.starter.handler;
import com.crio.starter.exceptions.MemeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class MemeNoFoudExceptionHandler {

    @Autowired
	private JSONObjects obj;
	@ExceptionHandler(MemeNotFoundException.class)
	public ResponseEntity<Object> MemeNotFoundException(MemeNotFoundException exe)
	{
		obj.setError(exe.getMessage());
		ResponseEntity<Object> retvalue=new ResponseEntity<Object>(obj,HttpStatus.NOT_FOUND);
		return retvalue;
	}
    
}
