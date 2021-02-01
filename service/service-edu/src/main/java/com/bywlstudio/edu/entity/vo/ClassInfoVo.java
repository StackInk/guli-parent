package com.bywlstudio.edu.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author: zl
 * @Date: Create in 2021/2/1 22:52
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ClassVO对象", description="VO对象")
public class ClassInfoVo {

    @ApiModelProperty(value = "课程讲师ID",example = "木易")
    private String teacherId;

    @ApiModelProperty(value = "课程专业ID",example = "123456")
    private String subjectId;

    @ApiModelProperty(value = "课程专业父级ID",example ="21312312")
    private String subjectParentId;

    @ApiModelProperty(value = "课程标题" ,example = "唯有热爱")
    private String title;

    @ApiModelProperty(value = "课程销售价格，设置为0则可免费观看",example = "0")
    private BigDecimal price;

    @ApiModelProperty(value = "总课时",example = "120")
    private Integer lessonNum;

    @ApiModelProperty(value = "课程封面图片路径",example = "123123")
    private String cover;

    @ApiModelProperty(value = "课程简介",example = "木易课程，讲解了如何过好四年的大学生活")
    private String description;
}
