package com.forfries.backend.util;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyuncs.exceptions.ClientException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OSSClientUtil {
    // 你的Bucket Name
    @Getter
    private static final String BUCKET_NAME = "forfries-upload-test";
    // 你的Endpoint, 比如华东1: http://oss-cn-hangzhou.aliyuncs.com
    @Getter
    private static final String ENDPOINT = "oss-cn-nanjing.aliyuncs.com";
//    // 你的AccessKeyId
//    private static final String ACCESS_KEY_ID = System.getenv("ACCESS_KEY_ID");
//    // 你的AccessKeySecret
//    private static final String ACCESS_KEY_SECRET = System.getenv("ACCESS_KEY_SECRET");


    private static final String region = "cn-nanjing";
    // 创建 OSSClient 实例
    public static OSS createOSSClient() {
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);

//        CredentialsProvider credentialsProvider = new DefaultCredentialProvider(ACCESS_KEY_ID, ACCESS_KEY_SECRET);


        EnvironmentVariableCredentialsProvider credentialsProvider = null;
        try {
            credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
            return  OSSClientBuilder.create()
                    .endpoint(ENDPOINT)
                    .credentialsProvider(credentialsProvider)
                    .clientConfiguration(clientBuilderConfiguration)
                    .region(region)
                    .build();

        } catch (ClientException e) {
            log.error("无法获取OSS密钥：{}",e.getMessage());
            throw new RuntimeException(e);
        }

    }


    // 关闭 OSSClient
    public static void closeOSSClient(OSS ossClient) {
        if (ossClient != null) {
            ossClient.shutdown();
        }
    }
}
