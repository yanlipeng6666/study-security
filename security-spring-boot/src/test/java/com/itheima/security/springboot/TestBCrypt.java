package com.itheima.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void test1() {
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println("===>  "+hashpw);

        boolean checkpw = BCrypt.checkpw("123", "$2a$10$xJb1.nzYYqsXQ6oZuEewjuAFk1PwbqabC8Kc3fWvwY8fyYiMLaaDa");
        System.out.println("====>"+checkpw);


    }
}
