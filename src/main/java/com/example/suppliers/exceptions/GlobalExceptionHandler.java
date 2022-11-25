package com.example.suppliers.exceptions;

import com.example.suppliers.constant.SuppliersConstants;
import com.example.suppliers.model.APIResponseDTO;
import com.example.suppliers.model.ErrorDetailsResponse;
import com.example.suppliers.utils.DateTimeUtils;
import com.example.suppliers.utils.SuppliersUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> BusinessExceptionHandler(BusinessException ex, WebRequest request)
            throws JsonProcessingException {

        logger.error(ex.getMessage(), ex);

        APIResponseDTO response = SuppliersUtil.prepeareAPIResponse(ex.message,
                null, ex.code);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestExceptionHandler(BadRequestException ex, WebRequest request)
            throws JsonProcessingException {

        logger.error(ex.getMessage(), ex);
        ErrorDetailsResponse errorDetails = new ErrorDetailsResponse(ex.getCode(),
                DateTimeUtils.createDateStringFromDate(null),
                SuppliersConstants.BAD_ERROR_RESPONSE_MESSAGE + " / " + ex.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) throws JsonProcessingException {

        logger.error(ex.getMessage(), ex);
        ErrorDetailsResponse errorDetails = new ErrorDetailsResponse(SuppliersConstants.GENERAL_ERROR_RESPONSE_CODE,
                DateTimeUtils.createDateStringFromDate(null),
                SuppliersConstants.GENERAL_ERROR_RESPONSE_CODE + " /  " + ex.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
