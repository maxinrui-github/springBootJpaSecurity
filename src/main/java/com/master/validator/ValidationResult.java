package com.master.validator;


import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/28
 * \* Time: 9:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ValidationResult {
    //校验结果
    private boolean hasErrors = false;
    //存放校验信息
    private Map<String, String> errorMsgMap ;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrorMsgMap() {
        return errorMsgMap;
    }

    public void setErrorMsgMap(Map<String, String> errorMsgMap) {
        this.errorMsgMap = errorMsgMap;
    }
    public String getErrMsg(){
        return StringUtils.join(errorMsgMap.values(),",");
       // return StringUtils.join(errorMsgMap.values().toArray(),",");
    }
}