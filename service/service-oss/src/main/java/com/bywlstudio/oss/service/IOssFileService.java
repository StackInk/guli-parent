package com.bywlstudio.oss.service;

import com.bywlstudio.base.exception.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: zl
 * @Date: Create in 2021/1/22 23:50
 * @Description:
 */

public interface IOssFileService {

    String uploadFile(MultipartFile file) throws FileUploadException;
}
