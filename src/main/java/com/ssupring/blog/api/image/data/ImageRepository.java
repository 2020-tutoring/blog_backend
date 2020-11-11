package com.ssupring.blog.api.image.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

   Optional<Image> findByFileId(String fileName);
}
