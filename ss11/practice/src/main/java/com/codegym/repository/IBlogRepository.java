package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%')" +
            " or b.author like concat('%',:author,'%')  or c.name like concat('%',:name,'%')  order by date  ",
            countQuery ="select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%') " +
                    "or b.author like concat('%',:author,'%') or c.name like concat('%',:name,'%')   order by date  ;",nativeQuery = true)
    List<Blog> searchTitleOrAuthorOrCategoryName2(@Param("title") String title, @Param("author")String author, @Param("name")String name);
}