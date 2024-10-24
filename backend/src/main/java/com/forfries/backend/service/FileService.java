package com.forfries.backend.service;

import com.forfries.backend.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;


/**
* @author Nolan
* @description 针对表【file】的数据库操作Service
* @createDate 2024-10-24 11:18:36
*/
public interface FileService extends IService<File> {

    String createFile(File file);

}
