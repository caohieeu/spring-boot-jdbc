package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.KeyAgreementSpi;

import org.hibernate.jpa.criteria.expression.function.SubstringFunction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.exception.AppException;
import com.javaweb.exception.ErrorCode;
import com.javaweb.models.ErrorResponseDTO;
import com.javaweb.models.response.ApiResponse;
import com.javaweb.repository.entity.BuildingEntity;

@ControllerAdvice
@ResponseBody
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handlerArithmeticException(
				ArithmeticException ex, WebRequest request
			) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Số nguyên không chia hết cho 0");
		errorResponseDTO.setDetails(details);
		return new ResponseEntity<Object>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AppException.class) 
	public ResponseEntity<ApiResponse> handlerAppException(
				AppException ex
			) {
		 ErrorCode errorCode = ex.getErrorCode();
	        return ResponseEntity.badRequest().body(
	                ApiResponse.builder()
	                        .code(errorCode.getCode())
	                        .message(errorCode.getMessage())
	                        .build()
	        );
	}
}
