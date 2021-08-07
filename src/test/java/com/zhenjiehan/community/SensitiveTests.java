package com.zhenjiehan.community;

import com.zhenjiehan.community.utils.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    void testSensitiveFilter() {
        String text = "这里可以赌博, 可以嫖娼, 可以开@票, 哈哈哈哈哈哈哈!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }

}
