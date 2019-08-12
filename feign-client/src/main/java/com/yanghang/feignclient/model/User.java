package com.yanghang.feignclient.model;

import lombok.Builder;
import lombok.Data;

/**
 * @program: springcloudcode
 * @description: 用户实体类
 * @author: YangHang
 * @create: 2019-08-12 22:10
 **/

@Builder
@Data
public class User {

    private String name;

    private int age;
}
