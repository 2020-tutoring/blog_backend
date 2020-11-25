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

  public Post getPost(String title) {
    Post post = postRepository.findByTitle(title);
    return post;
  }

  public void postPost(String author,String title,String body, LocalDateTime deadline) {
    Post newPost= new Post(author, title, body,deadline);
    PostRepository.save(newPost);
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
