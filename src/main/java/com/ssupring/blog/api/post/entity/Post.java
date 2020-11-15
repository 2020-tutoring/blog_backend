package com.ssupring.blog.api.post.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long postId;

  private String author;

  private String title;

  private String body;

  private LocalDateTime creationDateTime; //등록일

  private LocalDateTime deadline;//마감일


  @Builder
  public Post(Long id, String author, String title, String body, LocalDateTime deadline) {
    this.postId = id;
    this.author = author;
    this.title = title;
    this.body = body;
    this.deadline = deadline;
    creationDateTime = LocalDateTime.now();
  }
}
