package com.example.demo.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.entity.ViewImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
public class AmazonClient {
    private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;
    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = new AmazonS3Client(credentials);
    }

    private void uploadFileTos3bucketStream(String fileName, InputStream imageData, ObjectMetadata metadata) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, imageData, metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public void uploadFileStream(InputStream imageData, ObjectMetadata metadata, String orderId) {

        String fileUrl = "";
        try {
            String fileName = orderId;
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            uploadFileTos3bucketStream(fileName, imageData, metadata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadFileTos3bucket(String fileName, String imageData) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, imageData)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public void uploadFile(String imageData, String orderId) {

        String fileUrl = "";
        try {
            String fileName = orderId;
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            uploadFileTos3bucket(fileName, imageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
