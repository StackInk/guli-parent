package com.bywlstudio.edu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: zl
 * @Date: Create in 2021/1/11 22:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("教师查询条件对象")
public class TeacherQuery {

    @ApiModelProperty("教师姓名")
    private String name ;

    @ApiModelProperty("头衔 1高级讲师 2首席讲师")
    private Integer level ;

    @ApiModelProperty(value = "查询开始时间",example = "2019-10-30 11:55:19")
    private Date start ;

    @ApiModelProperty(value = "查询结束时间",example = "2019-10-30 11:55:19")
    private Date end ;
}
