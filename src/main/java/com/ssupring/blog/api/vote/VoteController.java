package com.ssupring.blog.api.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @GetMapping("주소")
    public Vote getCount(){
        return voteService.getCount();
    }
}
