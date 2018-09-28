package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.http.*;

import com.example.demo.model.Blog;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("")
    public Blog getOne(@RequestParam("name") String blogName) {
        System.out.println(blogName);
        Blog b = blogRepository.findByName(blogName);

        if(b == null)
            return null;
        return b;
    }

    @GetMapping("/all")
    public Iterable<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @PostMapping(value = "/post", 
    // consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }, RequestParam em vez de RequestBody
    produces = { MediaType.APPLICATION_JSON_VALUE })
    public Blog create(@RequestHeader("Authorization") String authorization, @RequestBody Map<String, String> body) {
        
        String name = body.get("name");
        String content = body.get("content");

        Blog blog = new Blog(name, content);

        blogRepository.save(blog);

        return blog;
    }
}