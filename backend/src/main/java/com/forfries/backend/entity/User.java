package com.forfries.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    private Long id;

    private String username;

    private String email;

    private String password;

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}