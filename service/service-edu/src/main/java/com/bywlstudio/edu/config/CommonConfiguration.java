package com.bywlstudio.edu.config;

import com.bywlstudio.edu.excel.ExcelListener;
import com.bywlstudio.edu.service.ISubjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zl
 * @Date: Create in 2021/1/25 23:25
 * @Description:
 */
@Configuration
public class CommonConfiguration {

    @Bean
    public ExcelListener excelListener(ISubjectService subjectService){
        return new ExcelListener(subjectService);
    }
}
