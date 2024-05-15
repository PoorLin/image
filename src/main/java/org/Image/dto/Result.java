package org.Image.dto;

public class Result<T>{
    private Integer returnCode;

    private T data;

    public Result(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public Result(Integer returnCode, T data) {
        this.returnCode = returnCode;
        this.data = data;
    }

    public Result() {
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
