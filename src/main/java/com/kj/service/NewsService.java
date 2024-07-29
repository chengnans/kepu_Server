package com.kj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kj.dto.*;
import com.kj.entity.News;

import java.io.IOException;
import java.util.List;

/**
 * @author 破晓
 * @date 2022-01-09 16:27
 */
public interface NewsService extends IService<News> {

    String PICTURE_PATH = "picture_path";

    String ID = "id";

    String TITLE = "title";

    String RELEASE_TIME = "release_time";

    String HITS = "hits";

    String CONTENT = "content";

    String NEWS_CATEGORY_ID = "news_category_id";

    String CREATE_TIME = "create_time";

    String UPDATE_TIME = "update_time";

    //author和source为后加
    String SOURCES = "sources";
    String AUTHOR = "author";

    /**
     * 添加新闻
     */
    boolean saveNews(NewsAddDTO dto) throws IOException;

    /**
     * 删除新闻根据id
     */
    boolean removeNews(Integer id);

    /**
     * 修改新闻
     */
    boolean updateNews(NewsUpdateDTO dto) throws IOException;

    /**
     * 根据 NEWS_CATEGORY_ID 获取 新闻展示列表
     */
    NewsPaging getNewsListByNewsCategoryId(Integer newsCategoryId, Integer current, Integer size);

    /**
     * 模糊查询新闻列表 根据 title
     */
    NewsPaging fuzzyQueryListByTitle(String title, Integer current, Integer size);

    /**
     * 获取新闻根据 id
     */
    NewsQueryDTO getNewsById(Integer id);
}
