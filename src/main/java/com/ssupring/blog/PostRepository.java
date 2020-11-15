package com.ssupring.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
     Post findByTitle(String title);
     Post makeTitle(String title, LocalDateTime deadline);
}
