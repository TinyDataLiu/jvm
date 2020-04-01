package com.alice.jvm.jvm03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@SpringBootApplication
public class Jvm03Application {

    public static void main(String[] args) {
        SpringApplication.run(Jvm03Application.class, args);
    }

    private Map<String, Object> map = new HashMap<>();

    @GetMapping("heap")
    public void heap() {
        while (true) {
            map.put(UUID.randomUUID().toString(), new Object());
        }
    }

}
