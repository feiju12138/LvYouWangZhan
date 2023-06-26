package com.lvyouwangzhan.pojo;

import lombok.Data;

@Data
public class ResponseResult {

    private String code;
    private String msg;

    public ResponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
