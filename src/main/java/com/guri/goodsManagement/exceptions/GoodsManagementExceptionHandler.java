package com.guri.goodsManagement.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.guri.goodsManagement.dto.ErrorResponse;
import com.guri.goodsManagement.exceptions.generic.BadRequestException;
import com.guri.goodsManagement.exceptions.generic.ConflictException;
import com.guri.goodsManagement.exceptions.generic.ForbiddenException;
import com.guri.goodsManagement.exceptions.generic.InternalServerErrorException;
import com.guri.goodsManagement.exceptions.generic.NoContentException;
import com.guri.goodsManagement.exceptions.generic.NotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GoodsManagementExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({	NotFoundException.class,
						java.util.NoSuchElementException.class})
	@ResponseBody
	public ErrorResponse notFoundException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({BadRequestException.class,Exception.class})
	@ResponseBody
	public ErrorResponse badRequestException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentException.class})
	@ResponseBody
	public ErrorResponse noContentException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({
		InternalServerErrorException.class,
		java.lang.NullPointerException.class
	})
	@ResponseBody
	public ErrorResponse internalServerErrorException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ForbiddenException.class, AccessDeniedException.class})
	@ResponseBody
	public ErrorResponse forbiddenException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ConflictException.class})
	@ResponseBody
	public ErrorResponse conflictException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(new ErrorResponse(ex, errorMessages.toString(), request.getContextPath()) , HttpStatus.BAD_REQUEST);
	}

}
