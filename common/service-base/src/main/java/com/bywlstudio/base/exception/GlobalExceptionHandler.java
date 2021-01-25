package com.bywlstudio.base.exception;

import com.bywlstudio.common.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zl
 * @Date: Create in 2021/1/12 22:45
 * @Description:
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exception(Exception e){
        log.info("出发全局异常处理:{}",e.getMessage());
        return R.error().message("全局异常处理");
    }


    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R arithmeticException(ArithmeticException e){
        log.info("出发移除处理:{}",e.getMessage());
        return R.error().message("ArithmeticException异常处理");
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseBody
    public R teacherNotFoundException(TeacherNotFoundException e){
        log.info("教师不存在异常");
        return R.error().code(e.getCode()).message(e.getMessage());
    }


    @ExceptionHandler(FileUploadException.class)
    @ResponseBody
    public R fileUploadException(FileUploadException e){
        log.info("文件上传失败"+e.getMessage());
        return R.error().code(e.getCode()).message(e.getMessage());
    }

    @ExceptionHandler(ExcelFileNullException.class)
    @ResponseBody
    public R excelFileNullException(ExcelFileNullException e){
        log.info("Excel文件为空"+e.getMessage());
        return R.error().code(e.getCode()).message(e.getMessage());
    }

}
