package com.ssupring.blog.api.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    public Vote getCount(){
        return null;
    }
}
