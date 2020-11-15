package com.ssupring.blog.api.post.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long postId;

  private String author;

  private String title;

  private String body;



  @Builder
  public Post(Long id, String author, String title, String body) {
    this.postId = id;
    this.author = author;
    this.title = title;
    this.body = body;
  }

}
