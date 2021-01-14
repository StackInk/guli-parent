package com.bywlstudio.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: Create in 2021/1/11 22:13
 * @Description:
 */
@Data
@ApiModel("统一结果返回对象")
public class R {
    @ApiModelProperty(name = "是否成功")
    private boolean success ;

    @ApiModelProperty(name = "状态码")
    private int code ;

    @ApiModelProperty(name = "响应消息")
    private String message ;

    @ApiModelProperty(name = "响应数据")
    private Map<String,Object> data = new HashMap<>();;

    private R(){}

    public static R ok(){
        R r = new R();
        r.setCode(ResultCode.OK);
        r.setMessage("成功");
        r.setSuccess(true);
        return r ;
    }
    public static R error(){
        R r = new R();
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        r.setSuccess(false);
        return r ;
    }

    public R data(String key , Object value){
        data.put(key,value);
        return this ;
    }

    public R data(Map<String,Object> map){
        this.data = map ;
        return this;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(int code){
        this.setCode(code);
        return this;
    }


}
