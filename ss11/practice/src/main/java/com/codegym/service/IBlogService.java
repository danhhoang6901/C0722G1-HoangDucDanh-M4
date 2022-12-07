package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    void update(Blog blog);

    Blog findById(int id);

    void delete(int id);

    void save(Blog blog);


    List<Blog> findAll();

//    List<Blog> searchTitleOrAuthorOrCategoryName2(String search);
}
