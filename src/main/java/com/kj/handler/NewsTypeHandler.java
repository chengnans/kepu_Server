package com.kj.handler;

import com.kj.dto.NewsTypeDTO;
import com.kj.permission.annotation.SuperAdmin;
import com.kj.service.NewsTypeService;
import com.kj.vo.Result;
import com.kj.vo.news.type.NewsTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 破晓
 * @date 2022-01-09 20:48
 */
@Api(tags = "新闻类型操作（大标题）")
@RestController
@RequestMapping("/news_type")
public class NewsTypeHandler {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsTypeService newsTypeService;

    @SuperAdmin
    @ApiOperation(value = "添加新闻类型", notes = "新闻类型名重复时会添加失败，并提示：name已经存在")
    @PostMapping("/add")
    public Result addNewsType(String name) {
        return new Result().ok().data(newsTypeService.saveNewsType(name));
    }

    @SuperAdmin
    @ApiOperation(value = "删除新闻类型")
    @PostMapping("/delete")
    public Result deleteNewsType(Integer id) {
        return new Result().ok().data(newsTypeService.removeNewsTypeById(id));
    }

    @SuperAdmin
    @ApiOperation(value = "修改新闻类型")
    @PostMapping("/update")
    public Result updateNewsType(NewsTypeVO vo) {
        return new Result().ok().data(newsTypeService.updateNewsType(modelMapper.map(vo, NewsTypeDTO.class)));
    }

    @ApiOperation(value = "查询全部新闻类型")
    @GetMapping("/all")
    public Result queryAll() {
        return new Result().ok().data(newsTypeService.getNewsTypeList());
    }
}
