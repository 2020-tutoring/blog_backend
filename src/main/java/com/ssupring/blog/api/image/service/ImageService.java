package com.ssupring.blog.api.image.service;

import com.ssupring.blog.api.image.data.Image;
import com.ssupring.blog.api.image.data.ImageRepository;
import com.ssupring.blog.api.image.exception.CantCreateFileDirectoryException;
import com.ssupring.blog.api.image.exception.FileDownloadException;
import com.ssupring.blog.configs.FileConfig;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

  private final Path ImageLocation;

  private final FileService fileService;

  private final ImageRepository imageRepository;

  @Autowired
  public ImageService(FileConfig config, ImageRepository imageRepository, FileService fileService) {
    this.imageRepository = imageRepository;
    this.fileService = fileService;
    this.ImageLocation = Paths.get(config.getImageDir())
        .toAbsolutePath().normalize();
    try {
      Files.createDirectories(this.ImageLocation);
    } catch (Exception e) {
      throw new CantCreateFileDirectoryException(this.ImageLocation.toString(), e);
    }
  }

  public void storeImage(long postId, long imageId, MultipartFile file) {

    String fileId = postId + "-" + imageId;
    String fileName = fileService.storeFile(file, this.ImageLocation, fileId);

    Image image = this.imageRepository.findById(imageId).orElse(new Image());
    String filePath = this.ImageLocation.resolve(fileName).toString();
    image.updateImage(fileId, filePath);
    imageRepository.save(image);
  }

  public Resource getImage(long postId, long imageId) {
    Image image = this.imageRepository.findByFileId(postId + "-" + imageId)
        .orElseThrow(() -> new FileDownloadException(postId + "-" + imageId));
    return fileService.loadFile(Paths.get(image.getFilePath()));
  }

  public void deleteImage(long postId, long imageId) {
    Image image = this.imageRepository.findByFileId(postId + "-" + imageId)
        .orElseThrow(() -> new FileDownloadException(postId + "-" + imageId));
    fileService.deleteFile(image.getFilePath());
    this.imageRepository.delete(image);
  }
}
