package com.codegym.controller;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogDto>> getBlogList() {
        List<Blog> blogDtos = blogService.findAll();
        if (blogDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<BlogDto> blogDtoList = new ArrayList<>();

        for (Blog x : blogDtos) {
            BlogDto blogDto = new BlogDto();
            BeanUtils.copyProperties(x, blogDto);
            blogDtoList.add(blogDto);
        }
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);

    }


}