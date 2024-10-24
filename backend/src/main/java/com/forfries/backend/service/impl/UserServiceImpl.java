package com.forfries.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forfries.backend.entity.User;
import com.forfries.backend.service.UserService;
import com.forfries.backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Nolan
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-10-24 11:18:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




