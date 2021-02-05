package com.bywlstudio.edu.service;

import com.bywlstudio.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bywlstudio.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author StackInk
 * @since 2021-02-01
 */
public interface IChapterService extends IService<Chapter> {

    List<ChapterVo> chapterVoList(String courseId);

}
