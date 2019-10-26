package com.example.demo.controllers;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.demo.entity.DatabaseImage;
import com.example.demo.entity.ViewImage;
import com.example.demo.services.AmazonClient;
import com.example.demo.services.myImageService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@CrossOrigin
public class MainController {


    @Autowired
    private myImageService imageService;

    @Autowired
    private AmazonClient amazonClient;


    @PostMapping("/qeats/v1/reviews/share")
    public String postImage(@RequestBody ViewImage image){
        byte[] bI = Base64.decodeBase64((image.getData().substring(image.getData().indexOf(",")+1)).getBytes());
        InputStream fis = new ByteArrayInputStream(bI);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(bI.length);
        amazonClient.uploadFileStream(fis,metadata, image.getOrderId());
        imageService.save(new DatabaseImage(image.getText(), image.getOrderId()));
        return "https://criostorage.s3.ap-south-1.amazonaws.com/"+ image.getOrderId();
    }




}