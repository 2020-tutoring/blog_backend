package com.ssupring.blog.api.image.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "imageId")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String fileId;
    private String filePath;

    public Image(String fileId, String filePath) {
        this.fileId = fileId;
        this.filePath = filePath;
    }

    public void updateImage(String fileId, String filePath) {
        this.fileId = fileId;
        this.filePath = filePath;
    }
}