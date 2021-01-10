package com.itheima.security.springboot.dao;

import com.itheima.security.springboot.model.PermissionDto;
import com.itheima.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 此处为了方便,不使用接口注入了,直接用类注入
 *
 * @author Administrator
 * @version 1.0
 **/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据账号查询用户信息
    public UserDto getUserByUsername(String username) {
        String sql = "select id,username,password,fullname,mobile from t_user where username = ?";
        //连接数据库查询用户
        List<UserDto> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDto.class));
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public List<String> getPermissionCodeByUserId(String userId) {
        String sql = "select a.* from t_permission as a \n" +
                "left join t_role_permission as b on  a.id = b.permission_id\n" +
                "left join t_user_role as c on b.role_id = c.role_id\n" +
                "where c.user_id = ? ";
        List<PermissionDto> permissionDtoList =  jdbcTemplate.query(sql,new Object[]{userId},new BeanPropertyRowMapper<>(PermissionDto.class));
        return permissionDtoList.stream().map(PermissionDto::getCode).collect(Collectors.toList());

    }
}
