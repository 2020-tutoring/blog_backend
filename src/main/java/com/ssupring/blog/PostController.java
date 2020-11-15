package com.ssupring.blog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/post{title}")
    public Post getPost(){
        return postService.getPost();
    }
    @PostMapping("/{title},{deadline}")
    public void postPost(@PathVariable("title") String title , @PathVariable("deadline")LocalDateTime deadline){
        postService.postPost(title, deadline);

    }

    public void closePost(){

    }
}
