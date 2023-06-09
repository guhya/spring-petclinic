/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.guhya.petclinic.module.common.api;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vitaliy Fedoriv
 */

@ControllerAdvice
public class ExceptionControllerAdvice {
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
    	e.printStackTrace();
        ErrorInfo errorInfo = new ErrorInfo(e);
        return prepareResponse(errorInfo, HttpStatus.BAD_REQUEST);        
    }

    /**
     * Handles exception thrown by Bean Validation on controller methods parameters
     *
     * @param ex      The thrown exception
     * @param request the current web request
     * @return an empty response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        BindingResult bindingResult = ex.getBindingResult();
        if (bindingResult.hasErrors()) {
            errors.addAllErrors(bindingResult);
        }
        
        return jsonResponse(errors.toJSON(), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Handles exception thrown by Bean Validation on controller methods parameters
     *
     * @param ex      The thrown exception
     * @param request the current web request
     * @return an empty response entity
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(code = BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ErrorInfo errorInfo = new ErrorInfo("ERR0002", "Method argument type mismatch");
        return prepareResponse(errorInfo, HttpStatus.BAD_REQUEST);        
    }
    
    private ResponseEntity<String> prepareResponse(ErrorInfo errorInfo, HttpStatus statusCode) {
        ObjectMapper mapper = new ObjectMapper();
        String respJSONstring = "{}";
        try {
            respJSONstring = mapper.writeValueAsString(errorInfo);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }

        return jsonResponse(respJSONstring, statusCode);
    }

    private ResponseEntity<String> jsonResponse(String json, HttpStatus statusCode) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(json, httpHeaders, statusCode);
    }

    public static class ErrorInfo {
        public final String code;
        public final String message;

        public ErrorInfo(Exception ex) {
            this.code = "ERR0001";
            this.message = ex.getLocalizedMessage();
        }
        
        public ErrorInfo(String code, String message) {
            this.code = code;
            this.message = message;
        }
        
    }
}
