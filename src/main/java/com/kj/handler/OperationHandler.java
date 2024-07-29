package com.kj.handler;

import com.kj.module.HeaderImgUpload;
import com.kj.permission.annotation.GeneralAdmin;
import com.kj.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 破晓
 * @date 2022-01-29 23:09
 *
 * 上传图片操作
 */
@Slf4j
@Api(tags = "其他操作")
@RestController
public class OperationHandler {

//    @GeneralAdmin
    @ApiOperation(value = "单文件上传")
    @PostMapping("/uploading")
    public Result filesUpload(MultipartFile file) throws IOException {
        String s = HeaderImgUpload.headPortraitUpload(file);
        return new Result().ok().data(s);
    }

}
