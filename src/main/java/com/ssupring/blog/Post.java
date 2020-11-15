package com.ssupring.blog;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Data
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "Asia/Seoul")
public class Post {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long postId;
    private String  title;
    private LocalDateTime creationDateTime; //등록일
    private LocalDateTime deadline;//마감일
    public Post(){}
    public Post(long postId, String title,LocalDateTime deadline){
        this.postId=postId;
        this.title=title;
        this.deadline=deadline;
        creationDateTime=LocalDateTime.now();
    }
}
