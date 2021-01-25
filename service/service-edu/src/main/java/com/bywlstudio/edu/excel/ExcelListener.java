package com.bywlstudio.edu.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bywlstudio.base.exception.ExcelFileNullException;
import com.bywlstudio.edu.entity.Subject;
import com.bywlstudio.edu.service.ISubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: zl
 * @Date: Create in 2021/1/25 23:22
 * @Description:
 */

@Slf4j
public class ExcelListener extends AnalysisEventListener<ExcelEntity> {

    private ISubjectService subjectService ;

    public ExcelListener(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(ExcelEntity excelEntity, AnalysisContext analysisContext) {
        if(null == excelEntity) throw new ExcelFileNullException("Excel文件为NULL",20002);

        log.info("读取一级分类：{},读取二级分类:{}",excelEntity.getOneTitle(),excelEntity.getTwoTitle());

        Subject subject ;
        if((subject = existOneTitle(excelEntity.getOneTitle())) == null){
            subject = new Subject();
            subject.setParentId("0");
            subject.setTitle(excelEntity.getOneTitle());
            subject.setSort(1);
            subjectService.save(subject);
        }

        if(existTwoTitle(excelEntity.getTwoTitle(),subject.getId()) == null){
            subject.setParentId(subject.getId());
            subject.setSort(2);
            subject.setTitle(excelEntity.getTwoTitle());
            subject.setId(null);
            subjectService.save(subject);
        }

    }

    private Subject existOneTitle(String oneTitle){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",oneTitle);
        queryWrapper.eq("parent_id","0");
        return subjectService.getOne(queryWrapper);
    }

    private Subject existTwoTitle(String twoTitle,String parentId){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",twoTitle);
        queryWrapper.eq("parent_id",parentId);
        return subjectService.getOne(queryWrapper);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("文件读取完成");
    }
}
