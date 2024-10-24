package com.forfries.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forfries.backend.entity.Directory;
import com.forfries.backend.entity.File;
import com.forfries.backend.mapper.DirectoryMapper;
import com.forfries.backend.service.FileService;
import com.forfries.backend.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Nolan
* @description 针对表【file】的数据库操作Service实现
* @createDate 2024-10-24 11:18:36
*/

@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File>
    implements FileService{

    @Autowired
    private FileMapper fileMapper;

    @Override
    public String createFile(File file) {

        log.info("id为：{}",file.getId());
        fileMapper.insert(file);

        return "";
    }

}




