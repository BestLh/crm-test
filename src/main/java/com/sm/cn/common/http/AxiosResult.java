package com.sm.cn.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult<T> {
    private int status;
    private String message;
    private T data;

    private AxiosResult() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * 成功返回的方法
     */
    public static <T> AxiosResult<T> success(){
        return setAxiosResult(AxiosStatus.OK, null);
    }

    /**
     * 成功返回的方法带数据
     */
    public static <T> AxiosResult<T> success(T data){
        return setAxiosResult(AxiosStatus.OK, data);
    }

    /**
     * 成功返回自定义状态码的方法
     */
    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus){
        return setAxiosResult(axiosStatus,null);
    }

    /**
     * 成功返回自定义状态码的方法带数据
     */
    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus,T data){
        return setAxiosResult(axiosStatus,data);
    }

    /**
     * 错误返回的方法
     */
    public static <T> AxiosResult<T> error(){
        return setAxiosResult(AxiosStatus.ERROR, null);
    }

    /**
     * 错误返回自定义状态码的方法
     */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus){
        return setAxiosResult(axiosStatus,null);
    }

    /**
     * 错误返回的方法带数据
     */
    public static <T> AxiosResult<T> error(T data){
        return setAxiosResult(AxiosStatus.ERROR, data);
    }

    /**
     * 错误返回自定义状态码的方法带数据
     */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus,T data){
        return setAxiosResult(axiosStatus,data);
    }

    /**
     * 封装数据公共方法
     * @param axiosStatus
     * @param data
     * @param <T>
     * @return
     */
    private static <T> AxiosResult<T> setAxiosResult(AxiosStatus axiosStatus, T data) {
        AxiosResult<T> axiosResult = new AxiosResult<>();
        axiosResult.setData(data);
        axiosResult.setStatus(axiosStatus.getStatus());
        axiosResult.setMessage(axiosStatus.getMessage());
        return axiosResult;
    }


}


