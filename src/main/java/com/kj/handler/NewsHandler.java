package com.kj.handler;

import com.kj.dto.NewsAddDTO;
import com.kj.dto.NewsQueryDTO;
import com.kj.dto.NewsUpdateDTO;
import com.kj.permission.annotation.GeneralAdmin;
import com.kj.service.NewsService;
import com.kj.vo.Result;
import com.kj.vo.news.NewsAddVO;
import com.kj.vo.news.NewsUpdateVO;
import com.kj.vo.news.PagingFuzzyQueryListByTitleVO;
import com.kj.vo.news.PagingQueryListByNewsCategoryIdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 破晓
 * @date 2022-01-11 14:32
 */
@Api(tags = "新闻主体操作")
@RestController
@RequestMapping("/news")
public class NewsHandler {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsService newsService;

    @GeneralAdmin
    @ApiOperation(value = "添加新闻")
    @PostMapping(value = "/add")
    public Result addNews(MultipartFile pictureFile, NewsAddVO vo) throws IOException {
        NewsAddDTO newsAddDTO = modelMapper.map(vo, NewsAddDTO.class);
        newsAddDTO.setPictureFile(pictureFile);
        return new Result().ok().data(newsService.saveNews(newsAddDTO));
    }

    @GeneralAdmin
    @ApiOperation(value = "删除新闻")
    @PostMapping("/delete")
    public Result deleteNews(Integer id) {
        return new Result().ok().data(newsService.removeNews(id));
    }

    @GeneralAdmin
    @ApiOperation(value = "修改新闻")
    @PostMapping("/update")
    public Result updateNews(MultipartFile pictureFile, NewsUpdateVO vo) throws IOException {
        NewsUpdateDTO newsUpdateDTO = modelMapper.map(vo, NewsUpdateDTO.class);
        newsUpdateDTO.setPictureFile(pictureFile);
        return new Result().ok().data(newsService.updateNews(newsUpdateDTO));
    }

    @ApiOperation(value = "分页查询指定小标题下的新闻列表，可指定当前页和每页条数")
    @PostMapping("/list")
    public Result pagingQueryListByNewsCategoryId(PagingQueryListByNewsCategoryIdVO vo) {
        return new Result().ok().data(newsService.getNewsListByNewsCategoryId(vo.getNewsCategoryId(), vo.getCurrent(), vo.getSize()));
    }

    @ApiOperation(value = "根据新闻标题模糊查询新闻列表，分页查新")
    @PostMapping("/fuzzy")
    public Result pagingFuzzyQueryListByTitle(PagingFuzzyQueryListByTitleVO vo) {
        return new Result().ok().data(newsService.fuzzyQueryListByTitle(vo.getTitle(), vo.getCurrent(), vo.getSize()));
    }

    @ApiOperation("获取新闻主体根据id")
    @GetMapping("/main/{id}")
    public Result queryNewsById(@PathVariable("id") Integer id) {
        NewsQueryDTO news = newsService.getNewsById(id);
        return new Result().ok().data(news);
    }
}
