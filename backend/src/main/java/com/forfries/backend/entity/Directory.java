package com.forfries.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName directory
 */
@TableName(value ="directory")
@Data
public class Directory implements Serializable {
    private Long id;

    private Long userId;

    private Long parentDirectoryId;

    private String directoryName;

    private Date createdAt;

    private static final long serialVersionUID = 1L;
}