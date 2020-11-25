package com.ssupring.blog.api.post.service;

import com.ssupring.blog.api.post.entity.Post;
import com.ssupring.blog.api.post.entity.PostRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Post getPost() {
    Post post = postRepository.findByTitle("제목");
    return post;
  }

  public void postPost(String title, LocalDateTime deadline) {
    //Post post = postRepository.makeTitle(title, deadline);
  }


  public List<Post> getPostList() {
    List<Post> postList = postRepository.findAll();
    List<String> List = new ArrayList<>();

    return postRepository.findAll();
  }

  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }
}
