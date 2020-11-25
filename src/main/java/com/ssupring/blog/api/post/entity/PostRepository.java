package com.ssupring.blog.api.post.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Long> {
  Post findByTitle(String title);
  Post deleteByPostId(Long postId);
  
}
