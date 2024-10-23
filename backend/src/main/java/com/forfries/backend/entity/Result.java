package com.forfries.backend.entity;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(0, "操作成功", data);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<>(1, message, null);
    }

}
