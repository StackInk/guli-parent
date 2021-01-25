package com.bywlstudio.edu.service;

import com.bywlstudio.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author StackInk
 * @since 2021-01-25
 */
public interface ISubjectService extends IService<Subject> {

    void uploadFile(MultipartFile file);

}
