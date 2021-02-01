package com.bywlstudio.edu.service;

import com.bywlstudio.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bywlstudio.edu.entity.vo.ClassInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author StackInk
 * @since 2021-02-01
 */
public interface ICourseService extends IService<Course> {

    void createCourse(ClassInfoVo classInfoVo);
}
