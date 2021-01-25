package com.bywlstudio.base.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: zl
 * @Date: Create in 2021/1/25 23:31
 * @Description:
 */
@Data
public class ExcelFileNullException extends RuntimeException {
    public ExcelFileNullException(String message,int code){
        super(message);
        this.code = code ;
    }

    @ApiModelProperty(value = "状态码",example = "201")
    private int code ;
}
