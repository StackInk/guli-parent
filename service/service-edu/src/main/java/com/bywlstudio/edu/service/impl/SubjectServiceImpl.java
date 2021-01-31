package com.bywlstudio.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.bywlstudio.edu.entity.Subject;
import com.bywlstudio.edu.entity.subject.ClassSort;
import com.bywlstudio.edu.excel.ExcelEntity;
import com.bywlstudio.edu.excel.ExcelListener;
import com.bywlstudio.edu.mapper.SubjectMapper;
import com.bywlstudio.edu.service.ISubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log_$logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author StackInk
 * @since 2021-01-25
 */
@Service
@Slf4j
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {


    @Resource
    private ExcelListener excelListener ;

    @Override
    public void uploadFile(MultipartFile file) {
        try {
            log.info("开始读取文件,名字为:{}",file.getOriginalFilename());
            EasyExcel.read(file.getInputStream(), ExcelEntity.class,excelListener).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassSort> listClassSort() {
        List<Subject> subjectList = this.list(null);
        Map<Boolean, List<Subject>> map = subjectList.stream().collect(Collectors.groupingBy(subject -> subject.getParentId().equals("0")));
        List<Subject> subjectList1 = map.get(true);
        List<Subject> subjectList2 = map.get(false);
        log.info("一级标题：{},二级标题：{}",subjectList1,subjectList2);
        List<ClassSort> lists = new ArrayList<>();
        for (Subject subject1 : subjectList1) {
            ClassSort classSort1 = new ClassSort();
            BeanUtils.copyProperties(subject1,classSort1);
            List<ClassSort> list2 = new ArrayList<>();
            classSort1.setChildren(list2);
            for (Subject subject2 : subjectList2) {
                if(subject2.getParentId().equals(subject1.getId())){
                    ClassSort classSort2 = new ClassSort();
                    BeanUtils.copyProperties(subject2,classSort2);
                    classSort1.getChildren().add(classSort2);
                }
            }
            lists.add(classSort1);
        }
        return lists;

    }
}
