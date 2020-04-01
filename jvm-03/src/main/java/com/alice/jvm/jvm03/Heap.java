package com.alice.jvm.jvm03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class Heap {


    private Map<String, Object> map = new HashMap<>();

    @GetMapping("h")
    public void heap() {
        while (true) {
            map.put(UUID.randomUUID().toString(), new Object());
        }
    }

}
