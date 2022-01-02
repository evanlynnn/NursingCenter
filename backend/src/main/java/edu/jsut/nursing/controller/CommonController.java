package edu.jsut.nursing.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("common")
public class CommonController {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("${web.upload-path}")
    private String path;

    @RequestMapping("upload")
    public String upload(MultipartFile file) {
        String oriFileName = file.getOriginalFilename();
        logger.info("Origin file name: " + oriFileName);
        String fileName = UUID.randomUUID() + oriFileName.substring(oriFileName.lastIndexOf('.'));
        try {
            FileOutputStream fos = new FileOutputStream(path + fileName);
            FileCopyUtils.copy(file.getInputStream(), fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
