package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.http.*;

import com.example.demo.model.Blog;
import com.example.demo.repository.*;
import com.example.demo.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("")
    public ResponseEntity<?> getOne(@RequestParam("name") String blogName) {
        Blog b = blogRepository.findByName(blogName);

        if (b == null)
            throw new ErrorException(HttpStatus.BAD_REQUEST, "Blog doesn't exist");
        return ResponseEntity.ok(b);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBlogs() {
        return ResponseEntity.ok(blogRepository.findAll());
    }

    @PostMapping(value = "",
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> create(@RequestHeader("Authorization") String authorization,
            @RequestBody Map<String, String> body) {

        String name = body.get("name");
        String content = body.get("content");

        Blog blog = new Blog(name, content);

        blogRepository.save(blog);

        return ResponseEntity.ok(blog);
    }
}