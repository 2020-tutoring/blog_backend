package com.ssupring.blog.api.image.controller;

import com.ssupring.blog.api.image.service.ImageService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/posts/{postId}/images/{imageId}")
public class ImageController {
  private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
  private final ImageService imageService;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void uploadImage(
      @PathVariable long postId,
      @PathVariable long imageId,
      @RequestParam("image") MultipartFile image
  ) {
    imageService.storeImage(postId,imageId,image);
  }

  @GetMapping
  public ResponseEntity<Resource> downloadImage(
      @PathVariable long postId,
      @PathVariable long imageId,
      HttpServletRequest request
  ) {
    // Load file as Resource
    Resource resource = imageService.getImage(postId, imageId);
    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      logger.info("Could not determine file type.");
    }
    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }

  @DeleteMapping
  public void deleteImage(
      @PathVariable long postId,
      @PathVariable long imageId
  ) {
    imageService.deleteImage(postId, imageId);
  }
}
