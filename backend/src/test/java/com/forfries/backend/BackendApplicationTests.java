package com.forfries.backend;

import com.forfries.backend.exception.BaseException;
import com.forfries.backend.service.impl.FileUploadServiceImplOSS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void osstest() throws FileNotFoundException {
        String filePath = "D:\\Test\\1.txt";
        String fileName = "1.txt";
        InputStream inputStream = new FileInputStream(filePath);
        FileUploadServiceImplOSS ossFileUploadService = new FileUploadServiceImplOSS();
        ossFileUploadService.uploadFile(inputStream, fileName,1);
    }

    @Test
    void exceptionTest() {
        throw new BaseException("test");
    }
}
