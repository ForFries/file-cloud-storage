package com.forfries.backend.exception;

public class FileNullException extends BaseException {
    public FileNullException() {
        super("没有上传任何文件，文件为空");
    }
}
