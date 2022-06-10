package com.w.controller;

import com.w.exception.BusinessException;
import com.w.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author blue
 * @version 1.0
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截SystemException
    @ExceptionHandler(value = SystemException.class)
    public Result doSystemException(SystemException e){

        System.out.println("SystemException~");

        e.printStackTrace();
        return new Result(e.getCode(), null, e.getMessage());

    }

    //拦截BusinessException(业务异常)
    @ExceptionHandler(value = BusinessException.class)
    public Result doBusinessException(BusinessException e){

        System.out.println("BusinessException~");

        e.printStackTrace();
        return new Result(e.getCode(), null, e.getMessage());

    }

    //拦截其他异常
    @ExceptionHandler(value = Exception.class)
    public Result doException(Exception e){

        System.out.println("catch~");

        e.printStackTrace();
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "抱歉，请稍后重试~");

    }

}
