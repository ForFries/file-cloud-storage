package com.forfries.backend.mapper;

import com.forfries.backend.entity.File;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Nolan
* @description 针对表【file】的数据库操作Mapper
* @createDate 2024-10-24 11:18:36
* @Entity com.forfries.backend.entity.File
*/
@Mapper
public interface FileMapper extends BaseMapper<File> {

}




