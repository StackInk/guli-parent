package com.bywlstudio.base.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.IOException;

/**
 * @Author: zl
 * @Date: Create in 2021/1/23 0:10
 * @Description:
 */
@Data
public class FileUploadException extends RuntimeException {
    public FileUploadException(String message,int code){
        super(message);
        this.code = code ;
    }

    @ApiModelProperty(value = "状态码",example = "201")
    private int code ;
}
