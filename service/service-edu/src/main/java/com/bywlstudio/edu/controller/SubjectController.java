package com.bywlstudio.edu.controller;


import com.bywlstudio.common.entity.R;
import com.bywlstudio.edu.entity.subject.ClassSort;
import com.bywlstudio.edu.service.ISubjectService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author StackInk
 * @since 2021-01-25
 */
@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

    @Resource
    private ISubjectService subjectService ;

    @PostMapping
    public R fileUpload(MultipartFile file){
        subjectService.uploadFile(file);
        return R.ok();
    }

    @GetMapping
    public R getList(){
        List<ClassSort> classSorts = subjectService.listClassSort();
        return R.ok().data("list",classSorts);
    }
}

