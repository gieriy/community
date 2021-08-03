package com.zhenjiehan.community;

import com.zhenjiehan.community.dao.DiscussPostMapper;
import com.zhenjiehan.community.dao.UserMapper;
import com.zhenjiehan.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    void contextLoads() {

    }

    @Test
    void testselect(){
        System.out.println(userMapper.updateHeader(101,"http://images.nowcoder.com/head/25t.png"));
    }

}
