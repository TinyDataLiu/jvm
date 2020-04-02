//package com.alice.jvm;
//
//import com.alice.jvm.bean.Emp;
//import com.alice.jvm.metaspace.MetaspaceUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Slf4j
//@SpringBootApplication
//public class Jvm02Application {
//
//    public static void main(String[] args) {
//        SpringApplication.run(Jvm02Application.class, args);
//        log.info("server start");
//    }
//
//    /**
//     * OOM heap
//     */
//    @Controller
//    class Heap {
//        private List<Emp> list = new ArrayList<>();
//
//        @RequestMapping("heap")
//        public void heap() {
//            int i = 0;
//            while (true) {
//                Emp emp = Emp.builder().id(++i).name(UUID.randomUUID().toString()).build();
//                list.add(emp);
//                if (i < 10)
//                    log.info(emp.toString());
//            }
//        }
//
//        @ResponseBody
//        @GetMapping("echo")
//        public String echo() {
//            return "success";
//        }
//    }
//
//    /**
//     * OOM non-heap
//     */
//    @Controller
//    class NonHeap {
//        List<Class<?>> list = new ArrayList<Class<?>>();
//
//        @RequestMapping("nonHeap")
//        public void nonHeap() {
//            while (true) {
//                list.addAll(MetaspaceUtil.createClasses());
//            }
//        }
//    }
//
//}
