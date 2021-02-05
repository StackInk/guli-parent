package com.bywlstudio.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bywlstudio.edu.entity.Chapter;
import com.bywlstudio.edu.entity.Video;
import com.bywlstudio.edu.entity.vo.ChapterVo;
import com.bywlstudio.edu.mapper.ChapterMapper;
import com.bywlstudio.edu.service.IChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bywlstudio.edu.service.IVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements IChapterService {

    @Resource
    private IVideoService videoService ;


    public List<ChapterVo> chapterVoList(String courseId){
        //查询Chapter
        QueryWrapper<Chapter> queryChapter = new QueryWrapper<>();
        queryChapter.eq("course_id",courseId);
        List<Chapter> chapters = baseMapper.selectList(queryChapter);

        //查询子章节

        QueryWrapper<Video> queryVideo = new QueryWrapper<>();
        queryVideo.eq("course_id", courseId);
        List<Video> videoList = videoService.list(queryVideo);
        log.info("课程ID为{},对应的章节有{}个,子章节有{}",courseId,chapters.size(),videoList.size());
        Map<String, List<Video>> listMap = videoList.stream().collect(Collectors.groupingBy(video -> video.getChapterId()));

        List<ChapterVo> list = new ArrayList<>();
        //遍历赋值
        chapters.forEach(chapter -> {
            ChapterVo cv1 = new ChapterVo();
            BeanUtils.copyProperties(chapter,cv1);
            List<ChapterVo> list1  = new ArrayList<>();
            cv1.setChapterVos(list1);
            List<Video> videos = listMap.get(chapter.getId());
            if(videos != null && !videos.isEmpty()){
                videos.forEach(video -> {
                    ChapterVo cv2= new ChapterVo();
                    BeanUtils.copyProperties(video,cv2);
                    list1.add(cv2);
                });
            }
            list.add(cv1);
        });

        log.info(list.toString());

        return list ;
    }

}
