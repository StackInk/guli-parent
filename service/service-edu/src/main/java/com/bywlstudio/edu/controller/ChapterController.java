package com.bywlstudio.edu.controller;


import com.bywlstudio.common.entity.R;
import com.bywlstudio.edu.entity.vo.ChapterVo;
import com.bywlstudio.edu.service.IChapterService;
import org.omg.SendingContext.RunTime;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author StackInk
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Resource
    private IChapterService chapterService ;


    @GetMapping("{id}")
    public R chapterVoList(@PathVariable("id") String courseId){
        List<ChapterVo> chapterVos = chapterService.chapterVoList(courseId);
        if(chapterVos.isEmpty()){
            throw new RuntimeException("章节不存在");
        }
        return R.ok().data("chapters",chapterVos);
    }







}

