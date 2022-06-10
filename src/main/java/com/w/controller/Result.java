package com.w.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author blue
 * @version 1.0
 */
@Data
public class Result {

    private Integer code;
    private Object data;
    private String message;

    public Result() {
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
