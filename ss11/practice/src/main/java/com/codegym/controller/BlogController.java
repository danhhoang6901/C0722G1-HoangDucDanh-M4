package com.codegym.controller;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ICategoryService categoryService;

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
    public ResponseEntity create(@RequestBody Blog blog) {
//        Blog blog = new Blog();
//        BeanUtils.copyProperties(blogDto, blog);
        blog.setCategory(categoryService.findById(blog.getCategory().getId()));
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Blog blog) {
        blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.update(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("/more")
//    public ResponseEntity<List<Blog>> getListBySearch2(@RequestParam(defaultValue = "") String search) {
//        List<Blog> blogList = blogService.searchTitleOrAuthorOrCategoryName2(search);
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
//
}