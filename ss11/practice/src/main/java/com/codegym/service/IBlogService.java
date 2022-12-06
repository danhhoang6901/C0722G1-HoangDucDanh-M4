package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {



    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    List<Blog> findAll();

    List<Blog> searchTitleOrAuthorOrCategoryName2(String search);
}
