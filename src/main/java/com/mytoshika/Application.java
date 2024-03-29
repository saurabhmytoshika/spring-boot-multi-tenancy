package com.mytoshika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
public class Application {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    
  }

}
