package com.bywlstudio.edu.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author StackInk
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_course")
@ApiModel(value="Course对象", description="课程")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程ID" ,hidden = true)
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

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

    @ApiModelProperty(value = "销售数量",example = "34")
    private Long buyCount;

    @ApiModelProperty(value = "浏览数量",example = "666")
    private Long viewCount;

    @ApiModelProperty(value = "乐观锁",hidden = true)
    @Version
    private Long version;

    @ApiModelProperty(value = "课程状态 Draft未发布  Normal已发布",example = "Normal")
    private String status;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除",hidden = true)
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
