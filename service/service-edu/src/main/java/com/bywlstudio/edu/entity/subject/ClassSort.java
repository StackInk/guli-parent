package com.bywlstudio.edu.entity.subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zl
 * @Date: Create in 2021/1/31 23:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassSort {
    private String id ;
    private String title ;

    private List<ClassSort> children ;
}
