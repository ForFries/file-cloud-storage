package com.forfries.backend.service;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface FileDirectoryService {

    Map<String, Object> getFilesAndDirectories(long directoryId);
}
