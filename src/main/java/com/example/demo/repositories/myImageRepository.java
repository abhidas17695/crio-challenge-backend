package com.example.demo.repositories;

import com.example.demo.entity.DatabaseImage;
import org.springframework.data.repository.CrudRepository;

public interface myImageRepository extends CrudRepository<DatabaseImage, String> {
}
