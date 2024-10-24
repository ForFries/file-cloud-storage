package com.forfries.backend.service;

import com.forfries.backend.entity.File;

import java.io.InputStream;

public interface FileUploadService {
    File uploadFile(InputStream inputStream, String originalFilename, long size);
}
