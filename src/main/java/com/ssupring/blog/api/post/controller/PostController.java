package com.ssupring.blog.api.post.controller;

import com.ssupring.blog.api.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

}