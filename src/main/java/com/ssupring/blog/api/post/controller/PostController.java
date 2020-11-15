package com.ssupring.blog.api.post.controller;

import com.ssupring.blog.api.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  /*@GetMapping("/")
  public String list() {
    List<PosTto> posttoList = postService.getPostList();
    .addAttribute("postList", posttoList);
    return "post/list.html";
  }
  */


  @DeleteMapping("/post/{postId}")
  public String delete(@PathVariable("postId") Long postId) {
    PostService.deletePost(postId);
    return "redirect:/";
  }
}
