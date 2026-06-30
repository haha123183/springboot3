package com.study.springboot3.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(description = "用户实体")
public class User {
    @Schema(description = "用户ID", example = "1")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Schema(description = "用户名", example = "张三")
    private String username;

    @Min(value = 1, message = "年龄必须大于0")
    @Max(value = 150, message = "年龄必须小于150")
    @Schema(description = "年龄", example = "25")
    private Integer age;

    @Schema(description = "头像URL", example = "https://example.com/avatar.jpg")
    private String avatar;

    @Email(message = "邮箱格式不正确")
    @Schema(description = "邮箱", example = "zhangsan@example.com")
    private String email;

    @Schema(description = "城市", example = "北京")
    private String city;

    @Schema(description = "创建时间", example = "2026-06-29T10:00:00")
    private LocalDateTime created;

    @Schema(description = "更新时间", example = "2026-06-29T10:00:00")
    private LocalDateTime updated;

    @Schema(description = "最后登录时间", example = "2026-06-29T10:00:00")
    private LocalDateTime lastLogin;

    @NotNull(message = "状态不能为空")
    @Schema(description = "状态（0-禁用，1-启用）", example = "1")
    private Integer status;

    public User() {
    }

    public User(Integer id, String username, Integer age, String avatar, String email,
                String city, LocalDateTime created, LocalDateTime updated,
                LocalDateTime lastLogin, Integer status) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.avatar = avatar;
        this.email = email;
        this.city = city;
        this.created = created;
        this.updated = updated;
        this.lastLogin = lastLogin;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
