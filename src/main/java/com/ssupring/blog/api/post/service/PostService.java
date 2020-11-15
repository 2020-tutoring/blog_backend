package com.ssupring.blog.api.post.service;

import com.ssupring.blog.api.post.entity.Post;
import com.ssupring.blog.api.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

/*
  public List<PosTto> getPostList() {
    List<Post> postList = PostRepository.findAll();
    List<PosTto> posttoList = new ArrayList<>();

    for(Post post : postList) {
      PosTto postto = PosTto.builder()
              .id(post.getId())
              .author(post.getAuthor())
              .title(post.getTitle())
              .content(post.getContent())
              .createdDate(post.getCreatedDate())
              .build();
      posttoList.add(postDto);
    }
    return posttoList;
  }
*/
  public static void deletePost(Long postId){
    PostRepository.deleteById(postId);
  }
}
