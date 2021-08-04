package com.zhenjiehan.community;

import com.zhenjiehan.community.dao.DiscussPostMapper;
import com.zhenjiehan.community.dao.LoginTicketMapper;
import com.zhenjiehan.community.dao.UserMapper;
import com.zhenjiehan.community.entity.DiscussPost;
import com.zhenjiehan.community.entity.LoginTicket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void testselect(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(123);
        loginTicket.setTicket("asd");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 *10));

        //loginTicketMapper.insertLoginTicket(loginTicket);
        loginTicketMapper.updateStatus("asd",1);
        System.out.println(loginTicketMapper.selectByTicket("asd"));

    }

}
