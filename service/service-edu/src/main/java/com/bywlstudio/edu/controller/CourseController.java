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
        String courseId = courseService.createCourse(classInfoVo);
        return R.ok().data("courseId",courseId);
    }


    @GetMapping("{id}")
    public R courseById(@PathVariable String id){
        ClassInfoVo classInfoVo = courseService.selectById(id);
        return R.ok().data("classInfo",classInfoVo);
    }

    @PutMapping
    public R updateCourse(@RequestBody ClassInfoVo classInfoVo){
        courseService.updateCourse(classInfoVo);
        return R.ok();
    }

    @DeleteMapping("{id}")
    public R deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
        return R.ok();
    }


}

