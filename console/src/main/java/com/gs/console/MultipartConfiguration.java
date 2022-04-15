package com.gs.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

/**
 * @User远
 * @Date2022/4/14
 */
@Slf4j
@Configuration
// 传multipart文件需要的配置类
public class MultipartConfiguration {

    //TODO
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir", "/tmp");

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new TableInputResolver();
        commonsMultipartResolver.setMaxUploadSize(-1);
        Resource resource = new FileSystemResource(TMP_DIR);
        try {
            commonsMultipartResolver.setUploadTempDir(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commonsMultipartResolver;
    }
}
