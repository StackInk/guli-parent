package com.bywlstudio.edu.service.impl;

import com.bywlstudio.edu.EduApplication8001;
import com.bywlstudio.edu.service.IChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: zl
 * @Date: Create in 2021/2/6 0:25
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ChapterServiceImplTest {

    @Resource
    private IChapterService chapterService ;

    @Test
    public void chapterVoList() {
        System.out.println(chapterService.chapterVoList("14"));
    }
}