package com.ssupring.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public Post getPost(){
        Post post = postRepository.findByTitle("제목");
        return post;
    }
    public void postPost(String title, LocalDateTime deadline){
        Post post=postRepository.makeTitle(title,deadline);
    }

}
