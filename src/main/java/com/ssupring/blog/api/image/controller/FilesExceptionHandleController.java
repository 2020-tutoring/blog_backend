package com.ssupring.blog.api.image.controller;

import com.ssupring.blog.api.common.response.ErrorResponse;
import com.ssupring.blog.api.image.exception.FileDownloadException;
import com.ssupring.blog.api.image.exception.FileNameException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FilesExceptionHandleController {

    @ExceptionHandler(FileNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleCantUploadFile(FileNameException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "3001", exception.getMessage());
    }

    @ExceptionHandler(FileDownloadException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleCantUploadFile(FileDownloadException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "3002", exception.getMessage());
    }
}
