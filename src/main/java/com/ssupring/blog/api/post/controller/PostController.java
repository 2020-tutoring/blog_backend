package com.ssupring.blog.api.post.controller;

import com.ssupring.blog.api.post.entity.Post;
import com.ssupring.blog.api.post.service.PostService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  /*@GetMapping("/")
  public String list() {
    List<PosTto> posttoList = postService.getPostList();
    .addAttribute("postList", posttoList);
    return "post/list.html";
  }
  */

  @DeleteMapping("/post/{postId}")
  public String delete(@PathVariable("postId") Long postId) {
    postService.deletePost(postId);
    return "redirect:/";
  }

  @GetMapping("/post{title}")
  public Post getPost() {
    return postService.getPost();
  }

  @PostMapping("/{title},{deadline}")
  public void postPost(@PathVariable("title") String title, @PathVariable("deadline")
      LocalDateTime deadline) {
    postService.postPost(title, deadline);

  }

  public void closePost() {

  }
}
