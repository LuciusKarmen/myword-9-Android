package com.example.myapplication.utils;


import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public int code;
    public String message;
    public T data;

    // 默认构造函数（Gson 需要）
    public Result() {}

    // 可选：如果你需要在 Java 中手动构造（比如模拟数据）
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.message = "操作成功";
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(int code, String message) {
        Result<T> result = new Result<>();
        result.code = code;
        result.message = message;
        result.data = null;
        return result;
    }
}
