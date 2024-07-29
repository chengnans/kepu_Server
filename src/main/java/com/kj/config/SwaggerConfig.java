package com.kj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 破晓
 * @date 2022-01-09 21:23
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
//                .groupName("hhhhhhhhhhh")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kj.handler"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo webAipInfo() {
        return new ApiInfoBuilder()
                .title("网站-新闻网")
                .description("本文档描述了新闻微服务接口定义")
                .version("1.0.0")
                .contact(new Contact("@poxiao", "https://blog.csdn.net/can_meng_yun?spm=1001.2101.3001.5343", "2406448949@qq.com"))
                .build();
    }
}

/**
 * {
 *   "code": 200,
 *   "success": true,
 *   "msg": "ok",
 *   "data": true,
 *   "cookie": null
 * }
 */
