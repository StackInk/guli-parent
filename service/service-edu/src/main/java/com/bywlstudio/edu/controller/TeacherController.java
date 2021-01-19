package com.bywlstudio.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bywlstudio.base.exception.TeacherNotFoundException;
import com.bywlstudio.common.entity.R;
import com.bywlstudio.common.entity.ResultCode;
import com.bywlstudio.edu.entity.Teacher;
import com.bywlstudio.edu.entity.TeacherQuery;
import com.bywlstudio.edu.service.ITeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author StackInk
 * @since 2021-01-10
 */
@Api(description = "教师管理")
@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin
@Slf4j
public class TeacherController {


    @Resource
    private ITeacherService teacherService ;

    @GetMapping
    @ApiOperation("教师列表")
    public R list(){

        return R.ok().data("data",teacherService.list(null));
    }


    @DeleteMapping("{id}")
    @ApiOperation("逻辑删除教师")
    public R delete(@ApiParam(name = "教师ID",required = true) @PathVariable String id){
        boolean b = teacherService.removeById(id);
        if(b){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @GetMapping("/{current}/{limit}")
    public R page(@PathVariable String current,
                  @PathVariable String limit){
        Page page = new Page(Long.parseLong(current),Long.parseLong(limit));
        teacherService.page(page,null);
        return R.ok().data("total",page.getTotal()).data("data",page.getRecords());
    }

    @PostMapping("/list/{current}/{limit}")
    public R pageCondition(@PathVariable String current,
                           @PathVariable String limit,
                           @RequestBody(required = false) TeacherQuery teacherQuery){
        Page page = new Page(Long.parseLong(current),Long.parseLong(limit));
        QueryWrapper wrapper = new QueryWrapper();
        if(!StringUtils.isEmpty(teacherQuery.getName())){
            wrapper.like("name",teacherQuery.getName());
        }
        if(!StringUtils.isEmpty(teacherQuery.getLevel())){
            wrapper.eq("level",teacherQuery.getLevel());
        }
        if(!StringUtils.isEmpty(teacherQuery.getStart())){
            wrapper.gt("gmt_create",teacherQuery.getStart());
        }
        if(!StringUtils.isEmpty(teacherQuery.getEnd())){
            wrapper.lt("gmt_create",teacherQuery.getEnd());
        }

        teacherService.page(page,wrapper);
        log.info("page:{}",page);

        return R.ok().data("total",page.getTotal()).data("data",page.getRecords());
    }

    @PostMapping
    public R addTeacher(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        return save ? R.ok() : R.error();
    }

    @GetMapping("{id}")
    public R getTeacherById(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher == null) throw new TeacherNotFoundException("教师没有发现", ResultCode.ERROR);
        return R.ok().data("data",teacher);
    }

    @PutMapping
    public R updateTeacher(@RequestBody Teacher teacher){
        boolean b = teacherService.updateById(teacher);
        return b ? R.ok() : R.error();
    }





}

