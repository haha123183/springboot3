package com.study.springboot3.controller;

import com.study.springboot3.common.Result;
import com.study.springboot3.entity.Student;
import com.study.springboot3.entity.User;
import com.study.springboot3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
@Tag(name = "用户管理", description = "提供用户的增删改查操作")
public class MvcController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @Operation(summary = "查询所有用户", description = "返回用户列表")
    public Result getAll() {
        List<User> users = userService.getAll();
        return Result.ok().data("users", users);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询用户", description = "返回单个用户对象")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        if (user != null) {
            return Result.ok().data("user", user);
        } else {
            return Result.error().message("用户不存在");
        }
    }

    @PostMapping
    @Operation(summary = "新增用户", description = "创建一个新的用户")
    public Result add(@Valid @RequestBody User user) {
        User addedUser = userService.add(user);
        return Result.ok().data("user", addedUser).message("用户创建成功");
    }

    @PutMapping
    @Operation(summary = "更新用户", description = "更新用户信息")
    public Result update(@Valid @RequestBody User user) {
        User updatedUser = userService.update(user);
        return Result.ok().data("user", updatedUser).message("用户更新成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "根据ID删除用户")
    public Result delete(@PathVariable Integer id) {
        boolean success = userService.delete(id);
        if (success) {
            return Result.ok().message("用户删除成功");
        } else {
            return Result.error().message("用户删除失败");
        }
    }

    @GetMapping("/getParam")
    @Operation(summary = "根据名称去查询", description = "根据名称查询用户信息")
    public Result getParam(String name){
        System.out.println("getParam---------" + name);
        return Result.ok();
    }

    @PostMapping("/login")
    @Operation(summary = "登录接口", description = "接收JSON格式用户账号密码完成登录")
    public Result login(@RequestBody User user){
        System.out.println("login---------" + user.getUsername());
        return Result.ok();
    }

    @PostMapping("/register")
    @Operation(summary = "注册接口", description = "注册")
    public Result register(@Valid @RequestBody Student student){
        return Result.ok();
    }
}
