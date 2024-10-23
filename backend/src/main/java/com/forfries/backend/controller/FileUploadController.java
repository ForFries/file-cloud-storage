package com.forfries.backend.controller;

import com.forfries.backend.entity.Result;
import com.forfries.backend.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService ;

    @PostMapping("/upload")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // 调用服务上传文件，并获取返回结果
            return Result.success(fileUploadService.uploadFile(file.getInputStream(), file.getOriginalFilename()));
        } catch (IOException e) {
            return Result.failure("文件上传失败: " + e.getMessage());
        }
    }
}