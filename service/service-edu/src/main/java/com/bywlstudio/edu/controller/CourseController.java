package com.bywlstudio.edu.controller;


import com.bywlstudio.common.entity.R;
import com.bywlstudio.edu.entity.vo.ClassInfoVo;
import com.bywlstudio.edu.service.ICourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author StackInk
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {


    @Resource
    private ICourseService courseService ;

    @GetMapping
    public R courseList(){
//        courseService.courseList();
        return R.ok();
    }

    @PostMapping
    public R createCourse(@RequestBody ClassInfoVo classInfoVo){
        courseService.createCourse(classInfoVo);
        return R.ok();
    }


}

