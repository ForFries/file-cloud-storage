package com.forfries.backend.mapper;

import com.forfries.backend.entity.Directory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Nolan
* @description 针对表【directory】的数据库操作Mapper
* @createDate 2024-10-24 11:16:47
* @Entity com.forfries.backend.entity.Directory
*/
@Mapper
public interface DirectoryMapper extends BaseMapper<Directory> {

}




