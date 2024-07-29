package com.kj.handler;

import com.kj.dto.NewsCategoryDTO;
import com.kj.dto.NewsCategorySaveDTO;
import com.kj.permission.annotation.SuperAdmin;
import com.kj.service.NewsCategoryService;
import com.kj.vo.Result;
import com.kj.vo.news.category.NewsCategoryAddVO;
import com.kj.vo.news.category.NewsCategoryListVO;
import com.kj.vo.news.category.NewsCategoryUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 破晓
 * @date 2022-01-10 13:51
 */
@Api(tags = "新闻类别操作（小标题）")
@RestController
@RequestMapping("/news_category")
public class NewsCategoryHandler {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsCategoryService newsCategoryService;

    @SuperAdmin
    @ApiOperation(value = "添加新闻类别")
    @PostMapping("/add")
    public Result addNewsCategory(NewsCategoryAddVO vo){
        return new Result().ok().data(newsCategoryService.saveNewsCategory(modelMapper.map(vo, NewsCategorySaveDTO.class)));
    }

    @SuperAdmin
    @ApiOperation(value = "删除新闻类别")
    @PostMapping("/delete")
    public Result deleteNewsCategory(Integer id) {
        return new Result().ok().data(newsCategoryService.removeNewsCategoryById(id));
    }

    @SuperAdmin
    @ApiOperation(value = "修改新闻类别")
    @PostMapping("/update")
    public Result updateNewsCategory(@RequestBody NewsCategoryUpdateVO vo) {
        return new Result().ok().data(newsCategoryService.updateNewsCategoryById(modelMapper.map(vo, NewsCategoryDTO.class)));
    }

    @ApiOperation(value = "查询全部新闻类别")
    @GetMapping("/all")
    public Result queryAll() {
        return new Result().ok().data(newsCategoryService.queryAll());
    }

    @ApiOperation(value = "查询新闻类别列表根据新闻类型id（大标题id）")
    @GetMapping("/list/{typeId}")
    public Result queryByNewsTypeId(@PathVariable("typeId") Integer id) {
        List<NewsCategoryDTO> list = newsCategoryService.queryNewCategoryByNewsTypeDd(id);
        return new Result().ok().data(modelMapper.map(list, new TypeToken<List<NewsCategoryListVO>>(){}.getType()));
    }
}
