package com.forfries.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forfries.backend.entity.Directory;
import com.forfries.backend.entity.File;
import com.forfries.backend.mapper.DirectoryMapper;
import com.forfries.backend.mapper.FileMapper;
import com.forfries.backend.service.FileDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileDirectoryServiceImpl implements FileDirectoryService {

    @Autowired
    DirectoryMapper directoryMapper;

    @Autowired
    FileMapper fileMapper;

    @Override
    public Map<String, Object> getFilesAndDirectories(long directoryId) {

        // 创建查询条件
        QueryWrapper<Directory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_directory_id", directoryId); // 设置查询条件

        // 使用selectList方法查询数据
        List<Directory> directoryList = directoryMapper.selectList(queryWrapper);

        QueryWrapper<File> queryWrapperFile = new QueryWrapper<>();
        queryWrapper.eq("directory_id", directoryId);

        List<File> fileList = fileMapper.selectList(queryWrapperFile);

        // 构建返回数据
        Map<String, Object> result = new HashMap<>();
        result.put("directories", directoryList);  // 返回文件夹列表
        result.put("files", fileList);      // 返回文件列表

        return result;

    }
}
