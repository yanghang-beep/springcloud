package com.yanghang.feignclient.feignservice;

import com.yanghang.feignclient.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("feign-server")
public interface UserFeignService {

    /*
     * 演示GET请求多参数传递
     */
    @RequestMapping(value = "/user/addUser",method = RequestMethod.GET)
    String addUser(@RequestParam("name") String name, @RequestParam("age") Integer age);

    /*
     * 演示POST请求多参数传递
     */
    @RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    String updateUser(@RequestBody User user);
}
