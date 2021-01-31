package com.bywlstudio.oss.controller;


import com.bywlstudio.base.exception.FileUploadException;
import com.bywlstudio.common.entity.R;
import com.bywlstudio.oss.service.IOssFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author: zl
 * @Date: Create in 2021/1/22 23:48
 * @Description:
 */
@Api(description = "OSS上传接口")
@RestController
@RequestMapping("/edu")
@CrossOrigin
public class OssFileController {

    @Resource
    private IOssFileService ossFileService ;

    @PostMapping
    @ApiOperation("上传文件")
    public R uploadFile(MultipartFile file) throws FileUploadException {
        String url = ossFileService.uploadFile(file);
        return R.ok().data("url",url);
    }
}
