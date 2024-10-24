package com.forfries.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName file
 */
@TableName(value ="file")
@Data
public class File implements Serializable {
    private Long id;

    private Long userId;

    private Long directoryId;

    private String uuidFileName;

    private String originalFileName;

    private String fileUrl;

    private Long fileSize;

    private String fileType;

    private Date uploadTime;

    private static final long serialVersionUID = 1L;
}