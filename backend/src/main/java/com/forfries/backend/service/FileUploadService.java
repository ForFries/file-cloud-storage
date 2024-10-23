package com.forfries.backend.service;

import com.forfries.backend.entity.Result;

import java.io.InputStream;

public interface FileUploadService {
    String uploadFile(InputStream inputStream, String originalFilename);
}
