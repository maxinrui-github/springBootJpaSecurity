package com.master.response;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/27
 * \* Time: 16:22
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CommonReturnType {
    //表明对应请求的返回处理结果“success” “fail”
    private String status;
    // success -- data返回前所需要的json数据
    //fail -- data使用通用的错误码格式
    private Object data;

    public CommonReturnType(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    //定义一个通用的创建方法
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        return new CommonReturnType(status, result);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}