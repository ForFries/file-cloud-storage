package com.forfries.backend.mapper;

import com.forfries.backend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Nolan
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-24 11:18:39
* @Entity com.forfries.backend.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




