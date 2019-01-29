package com.huya.springvalidationtest.exception;

import com.huya.springvalidationtest.model.Result;
import com.huya.springvalidationtest.tools.UtilTools;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BindException.class)
    public String handleBindException(BindException e){
        StringBuilder sb = new StringBuilder();
        FieldError fieldError = e.getFieldError();
        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
                .append(fieldError.getDefaultMessage());
        return UtilTools.getJSONString(new Result(400, sb.toString()));
    }
}