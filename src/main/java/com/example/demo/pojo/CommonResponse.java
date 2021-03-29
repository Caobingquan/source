package com.example.demo.pojo;

import java.io.Serializable;

/**
 * @author 吴宏昌
 * @Title CommonResponse
 * @Description
 * @date 19-7-18
 */
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timeStamp;

    private Long status = 0L;

    private String code = "0";

    private T results;

    private Integer errorCode;

    private String errorMessage;

    public CommonResponse() {
    }

    public CommonResponse(T results) {
        this.results = results;
    }
    public CommonResponse(T results,Long status) {
        this.results = results;
        this.status = status;
    }

    public Long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResults() {
        return this.results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse(true);
    }

    public static <T> CommonResponse<T> fail() {
        return new CommonResponse(false);
    }

}
