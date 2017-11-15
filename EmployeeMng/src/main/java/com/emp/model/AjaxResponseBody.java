package com.emp.model;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by Developer PC on 10/30/2017.
 */
public class AjaxResponseBody {
    @JsonView()
    private
    String msg;

    @JsonView()
    private
    String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
