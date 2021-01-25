package com.bywlstudio.edu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: zl
 * @Date: Create in 2021/1/25 23:23
 * @Description:
 */
@Data
public class ExcelEntity {

    @ExcelProperty(index = 0)
    private String oneTitle ;

    @ExcelProperty(index = 1)
    private String twoTitle ;
}
