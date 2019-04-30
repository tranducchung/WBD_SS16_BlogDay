package com.codegym.cms.service;

import com.codegym.cms.model.Blog;

public interface BlogService {
    Iterable<Blog> findAll();

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    void save(Blog blog);
}
