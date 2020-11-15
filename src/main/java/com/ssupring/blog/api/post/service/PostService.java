package com.ssupring.blog.api.post.service;

import com.ssupring.blog.api.post.entity.Post;
import com.ssupring.blog.api.post.entity.PostRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public Post getPost() {
    Post post = postRepository.findByTitle("제목");
    return post;
  }

  public void postPost(String title, LocalDateTime deadline) {
    //Post post = postRepository.makeTitle(title, deadline);
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
  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }
}
