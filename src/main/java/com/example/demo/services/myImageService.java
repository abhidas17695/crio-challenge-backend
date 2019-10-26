package com.example.demo.services;

import com.example.demo.entity.DatabaseImage;
import com.example.demo.repositories.myImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class myImageService {

    @Autowired
    private myImageRepository imageRepository;

    public void save(DatabaseImage image){
        imageRepository.save(image);
    }

}
