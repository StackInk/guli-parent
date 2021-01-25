package com.bywlstudio.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.bywlstudio.edu.entity.Subject;
import com.bywlstudio.edu.excel.ExcelEntity;
import com.bywlstudio.edu.excel.ExcelListener;
import com.bywlstudio.edu.mapper.SubjectMapper;
import com.bywlstudio.edu.service.ISubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log_$logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

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
}
