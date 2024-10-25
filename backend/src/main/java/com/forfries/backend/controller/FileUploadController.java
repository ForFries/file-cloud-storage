package com.forfries.backend.controller;

import com.forfries.backend.BackendApplication;
import com.forfries.backend.entity.File;
import com.forfries.backend.entity.Result;
import com.forfries.backend.exception.BaseException;
import com.forfries.backend.exception.FileNullException;
import com.forfries.backend.service.FileService;
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

    @Autowired
    private FileService fileService ;

    @PostMapping("/upload")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file)throws BaseException {

        // 调用服务上传文件，并获取返回结果
        File newfile = null;
        try {
            newfile = fileUploadService.uploadFile(file.getInputStream(), file.getOriginalFilename(),file.getSize());
        } catch (Exception e) {
            throw new FileNullException();
        }

        fileService.createFile(newfile);


        return Result.success(newfile.getFileUrl());

    }
}
