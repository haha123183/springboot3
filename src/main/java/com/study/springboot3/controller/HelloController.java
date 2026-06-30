package com.study.springboot3.controller;

import com.study.springboot3.common.Result;
import com.study.springboot3.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "hello world";
    }

    @GetMapping("test2")
    public String test2() {
        return "hello";
    }
    @GetMapping("test3")
    @ResponseBody
    public Map<String, User> test3() {
        User user =new User();
        user.setUsername("张三");
        user.setAge(18);
        user.setId(1);
        User user1 =new User();
        user1.setUsername("李四");
        user1.setAge(16);
        user1.setId(2);
        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        map.put("user1", user1);
        return map;
    }
    @GetMapping("test4")
    @ResponseBody
    public Result test4() {
        User user =new User();
//        user.setName("张三");
//        user.setAge(18);
//        user.setId(1);
      return Result.ok().data("user", user);
     }
}
