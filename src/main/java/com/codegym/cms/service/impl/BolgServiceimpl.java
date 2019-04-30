package com.codegym.cms.service.impl;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.BlogRepository;
import com.codegym.cms.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

public class BolgServiceimpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.delete(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }
}
