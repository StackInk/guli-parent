package com.bywlstudio.edu.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: zl
 * @Date: Create in 2021/2/5 23:32
 * @Description:
 */
@Data
public class ChapterVo {

    @ApiModelProperty(value = "章节ID")
    private String id ;

    @ApiModelProperty(value = "课程ID")
    private String courseId;

    @ApiModelProperty(value = "章节名称")
    private String title ;

    @ApiModelProperty(value = "子章节")
    private List<ChapterVo> children ;
}
