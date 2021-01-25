package com.bywlstudio.edu.controller;


import com.bywlstudio.common.entity.R;
import com.bywlstudio.edu.service.ISubjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author StackInk
 * @since 2021-01-25
 */
@RestController
@RequestMapping("/edu/subject")
@CrossOrigin
public class SubjectController {

    @Resource
    private ISubjectService subjectService ;

    @PostMapping
    public R fileUpload(MultipartFile file){
        subjectService.uploadFile(file);
        return R.ok();
    }
}

