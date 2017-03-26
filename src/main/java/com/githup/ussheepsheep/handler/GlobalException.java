package com.githup.ussheepsheep.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by daren on 10/30/2016.
 */
@ControllerAdvice
public class GlobalException {

    /**
     * 错误信息类
     */
    private class ErrorInfo{
        boolean result = false;
        String message = "";

        public ErrorInfo(String message){
            this.message = message;
        }
    }

    /**
     * 处理验证出现异常的情况
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorInfo methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        ErrorInfo errorInfo = new ErrorInfo(e.getBindingResult().getFieldError().getDefaultMessage());
        return errorInfo;
    }
}
