package com.itheima.security.springmvc.service;

import com.itheima.security.springmvc.model.AuthenticationRequest;
import com.itheima.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    //用户信息
    private Map<String, UserDto> userMap = new HashMap<>();


    {
        HashSet<String> authorities1 = new HashSet<>();
        authorities1.add("p1");//这个p1我们人为让它和/r/r1对应
        userMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "133443",authorities1));

        HashSet<String> authorities2 = new HashSet<>();
        authorities2.add("p2");//这个p2我们人为让它和/r/r2对应
        userMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "144553",authorities2));
    }

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null || StringUtils.isEmpty(authenticationRequest.getUsername()) || StringUtils.isEmpty(authenticationRequest.getPassword())) {
            throw new RuntimeException("账号或密码为空");
        }
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if (userDto == null) {
            throw new RuntimeException("查询不到该用户");
        }
        if (!authenticationRequest.getPassword().equals(userDto.getPassword())) {
            throw new RuntimeException("账号或密码错误");
        }
        return userDto;
    }

    //模拟用户查询
    public UserDto getUserDto(String username) {
        return userMap.get(username);
    }

}
