package com.bywlstudio.base.exception;

import com.bywlstudio.common.entity.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: zl
 * @Date: Create in 2021/1/12 22:49
 * @Description:
 */
@Data
public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(String message,int code){
        super(message);
        this.code = code ;
    }

    @ApiModelProperty(value = "状态码",example = "201")
    private int code ;
}
