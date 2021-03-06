package com.accolite;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // starting point
public class AccoliteApplication {

  public static void main(String[] args) {
    // SpringApplication.run(AccoliteApplication.class, args);
    SpringApplication app = new SpringApplication(AccoliteApplication.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
    app.run(args);
  }

}
