package com.kj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kj.dto.NewsTypeDTO;
import com.kj.entity.NewsType;

import java.util.List;

/**
 * @author 破晓
 * @date 2022-01-09 15:59
 */
public interface NewsTypeService extends IService<NewsType> {

    String ID = "id";

    String NAME = "name";

    String CREATE_TIME = "create_time";

    String UPDATE_TIME = "update_time";

    /**
     * 添加新闻类型
     */
    boolean saveNewsType(String name);

    /**
     * 移除新闻类型根据id
     */
    boolean removeNewsTypeById(Integer id);

    /**
     * 修改新闻类型
     */
    boolean updateNewsType(NewsTypeDTO dto);

    /**
     * 查询全部新闻类型
     */
    List<NewsTypeDTO> getNewsTypeList();
}
