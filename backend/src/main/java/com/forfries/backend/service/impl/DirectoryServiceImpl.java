package com.forfries.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forfries.backend.entity.Directory;
import com.forfries.backend.mapper.DirectoryMapper;
import com.forfries.backend.service.DirectoryService;
import org.springframework.stereotype.Service;

/**
* @author Nolan
* @description 针对表【directory】的数据库操作Service实现
* @createDate 2024-10-24 11:16:47
*/
@Service
public class DirectoryServiceImpl extends ServiceImpl<DirectoryMapper, Directory>
    implements DirectoryService {

}




