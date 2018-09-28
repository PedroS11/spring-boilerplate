package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.*;

public interface BlogRepository extends CrudRepository<Blog, Integer> {

    Blog findByName(String name);

}