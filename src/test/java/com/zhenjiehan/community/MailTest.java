package com.zhenjiehan.community;


import com.zhenjiehan.community.utils.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.Context;

@SpringBootTest
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Autowired
    TemplateEngine templateEngine;
    @Test
    public void sendTextMail() {
        mailClient.sendMail("497039174@qq.com","Test","Welcome to email!");
    }

    @Test
    public void sendHtmlMail() {
        Context context = new Context();
        context.setVariable("username","猫杰瑞");
        String process = templateEngine.process("/mail/demo", context);
        System.out.println(process);
        mailClient.sendMail("497039174@qq.com","HTML",process);

    }
}
