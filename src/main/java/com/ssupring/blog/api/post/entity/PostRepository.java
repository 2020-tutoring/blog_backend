package com.ssupring.blog.api.post.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  Post findByTitle(String title);
  Post deleteByPostId(Long postId);
}
