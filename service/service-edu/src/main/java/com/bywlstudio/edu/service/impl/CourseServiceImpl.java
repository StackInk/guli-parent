package com.bywlstudio.edu.service.impl;

import com.bywlstudio.edu.entity.Course;
import com.bywlstudio.edu.entity.CourseDescription;
import com.bywlstudio.edu.entity.vo.ClassInfoVo;
import com.bywlstudio.edu.mapper.CourseMapper;
import com.bywlstudio.edu.service.ICourseDescriptionService;
import com.bywlstudio.edu.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author StackInk
 * @since 2021-02-01
 */
@Service
@Slf4j
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Resource
    private ICourseDescriptionService courseDescriptionService ;

    @Override
    public void createCourse(ClassInfoVo classInfoVo) {
        //插入课程信息
        Course course = new Course();
        BeanUtils.copyProperties(classInfoVo,course);
        int i = baseMapper.insert(course);
        log.info("Course:{}",course);

        //插入课程描述信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(classInfoVo.getDescription());
        courseDescription.setId(course.getId());
        boolean j = courseDescriptionService.save(courseDescription);
        log.info("CourseDescription:{}",courseDescription);
        //判断是否成功
        if(i <= 0 || !j){
            throw new RuntimeException("课程增加失败");
        }

    }
}
