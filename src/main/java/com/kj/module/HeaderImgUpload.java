package com.kj.module;

import com.kj.exception.HintException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author 破晓
 * @date 2021/8/2 - 1:56
 * 用于照片上传
 */
@Slf4j
public class HeaderImgUpload {

    //静态资源路径
    private static final String FILE_PATH_PREFIX = "static/images";

    private static final String FILE_PATH_PREFIX_READ = "images";

    //文件路径后缀
    private static final String FILE_PATH_SUFFIX = ".png";

    // 默认的图片后缀
    private static final List<String> FILE_TYPE = Arrays.asList("image/jpeg", "image/png");

    public static String headPortraitUpload(MultipartFile file) throws IOException, HintException {

        System.out.println(file.getContentType());
        if (!FILE_TYPE.contains(file.getContentType())) {
            throw new HintException("上传的文件类型只能是:" + FILE_TYPE.toString());
        }

        String path = System.getProperty("user.dir");
        File upload = new File(path, FILE_PATH_PREFIX);

        log.info("目录upload: " + upload.toString());
        if (!upload.exists()) {
            log.info("目录不存在，开始创建: " + upload.toString());
            if (!upload.mkdirs()) {
                throw new HintException("文件上传失败");
            }
        }

        File file1;
        UUID fileName = UUID.randomUUID();
        if (!file.isEmpty()) {
            log.info("开始保存");
            //保存到文件服务器
            file1 = new File(upload, fileName + FILE_PATH_SUFFIX);
            file.transferTo(file1);
        } else {
            throw new NullPointerException("文件不能为空");
        }
        return FILE_PATH_PREFIX_READ + File.separator + fileName + FILE_PATH_SUFFIX;
    }

    /*public static String getPortraitPath(String headPortraitId) {
        // 检查文件是否存在，不存在使用默认文件路径
        String path = System.getProperty("user.dir");
        File upload = new File(path, FILE_PATH_PREFIX + File.separator + headPortraitId + FILE_PATH_SUFFIX);
        if (!upload.exists()) {
            return FILE_PATH_PREFIX_READ + File.separator + DEFAULT_HEAD_PORTRAIT + FILE_PATH_SUFFIX;
        }
        return FILE_PATH_PREFIX_READ + File.separator + headPortraitId + FILE_PATH_SUFFIX;
    }

    public static void deleteOutdatedPhotos(String fileName) {
        if (DEFAULT_HEAD_PORTRAIT.equals(fileName)) {
            return;
        }
        String path = System.getProperty("user.dir");
        String filePath = FILE_PATH_PREFIX + File.separator + fileName + FILE_PATH_SUFFIX;
        File delete = new File(path, filePath);
        delete.delete();
    }*/

}
