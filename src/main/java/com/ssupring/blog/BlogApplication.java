package com.ssupring.blog;

import com.ssupring.blog.configs.FileConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({FileConfig.class})
@SpringBootApplication
public class BlogApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogApplication.class, args);
  }

}
