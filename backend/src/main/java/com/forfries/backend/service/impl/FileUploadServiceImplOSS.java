package com.forfries.backend.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.model.PutObjectRequest;
import com.forfries.backend.service.FileUploadService;
import com.forfries.backend.util.OSSClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Service
public class FileUploadServiceImplOSS implements FileUploadService {

    @Override
    public String uploadFile(InputStream inputStream, String originalFilename) {
        // 创建OSSClient实例

        OSS ossClient = OSSClientUtil.createOSSClient();

        // 使用UUID作为文件名
        String uuid = UUID.randomUUID().toString();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String objectName =  uuid + fileExtension;

        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(OSSClientUtil.getBUCKET_NAME(),objectName, inputStream);
            // 创建PutObject请求。
            ossClient.putObject(putObjectRequest);

            log.info("上传文件成功，文件名：{}",originalFilename);
            return "https://" + OSSClientUtil.getBUCKET_NAME() + "." + OSSClientUtil.getENDPOINT() + "/" + objectName;

        } catch (OSSException oe) {

            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message:{}", oe.getErrorMessage());
            log.error("Error Code:{}", oe.getErrorCode());
            log.error("Request ID:{}", oe.getRequestId());
            log.error("Host ID:{}", oe.getHostId());

            return null;
        } catch (ClientException ce) {

            log.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message:{}", ce.getMessage());

            return null;
        } finally {

            OSSClientUtil.closeOSSClient(ossClient);
        }
    }
}
