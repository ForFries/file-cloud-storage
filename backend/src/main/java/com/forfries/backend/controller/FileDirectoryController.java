package com.forfries.backend.controller;

import com.forfries.backend.entity.Result;
import com.forfries.backend.service.DirectoryService;
import com.forfries.backend.service.FileDirectoryService;
import com.forfries.backend.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/directory")
public class FileDirectoryController {
    @Autowired
    FileDirectoryService fileDirectoryService;

    @GetMapping("/{directoryId}")
    public Result<Map<String,Object>> getFileAndDirectory(@PathVariable long directoryId) {

        return Result.success(fileDirectoryService.getFilesAndDirectories(directoryId));
    }
}
