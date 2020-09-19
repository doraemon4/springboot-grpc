package com.stephen.learning;

import com.stephen.learning.service.UserService;
import com.stephen.learning.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jack
 * @description
 * @date 2020/9/17 0:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class AppTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        UserVO userVO = userService.getUser("jack");
        System.out.println(userVO);
    }
}
