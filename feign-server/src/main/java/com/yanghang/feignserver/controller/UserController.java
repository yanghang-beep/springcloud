package com.yanghang.feignserver.controller;


import com.yanghang.feignserver.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springcloudcode
 * @description: Feign服务提供控制类
 * @author: YangHang
 * @create: 2019-08-12 22:04
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    /* 演示POST GRT请求的多参数传递 */

    @GetMapping("/addUser")
    public String addUser(User user) {
        return user.toString();
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        return user.toString();
    }
}
