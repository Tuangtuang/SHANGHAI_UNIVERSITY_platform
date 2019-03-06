package com.example.demo.tools;


import com.example.demo.model.ov.Result;

import java.util.List;

import static com.example.demo.model.ResultCode.fail;
import static com.example.demo.model.ResultCode.success;

// 返回格式模板
public class ResultTool {

    public static Result<List<Object>> success(List<Object> object){
        Result<List<Object>> result = new Result<>();
        result.setStatus(success);
        result.setData(object);
        return result;
    }

    public static Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setStatus(success);
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setStatus(success);
        result.setData(null);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setStatus(fail);
        result.setData(null);
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(fail);
        result.setData(null);
        return result;
    }
}
