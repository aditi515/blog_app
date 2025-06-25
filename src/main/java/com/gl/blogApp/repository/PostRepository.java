package com.gl.blogApp.repository;

import com.gl.blogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
