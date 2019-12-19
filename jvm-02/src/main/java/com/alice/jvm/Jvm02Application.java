package com.alice.jvm;

import com.alice.jvm.bean.Emp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class Jvm02Application {

    public static void main(String[] args) {
        SpringApplication.run(Jvm02Application.class, args);
        log.info("server start");
    }

    @Controller
    class Heap {

        private List<Emp> list = new ArrayList<>();

        @RequestMapping("heap")
        public void heap() {
            int i = 0;
            while (true) {
                list.add(Emp.builder().id(++i).name(UUID.randomUUID().toString()).build());
            }
        }
    }
}
