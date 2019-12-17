package com.alice.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Jvm02Application {

    public static void main(String[] args) {
        SpringApplication.run(Jvm02Application.class, args);
    }

    @Controller
    class Heap {

        private List<Object> list = new ArrayList<>();

        @RequestMapping("heap")
        public void heap() {
            while (true) {
                list.add(new Object());
            }
        }
    }
}
