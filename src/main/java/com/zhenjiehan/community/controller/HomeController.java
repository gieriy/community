package com.zhenjiehan.community.controller;

import com.zhenjiehan.community.entity.DiscussPost;
import com.zhenjiehan.community.entity.Page;
import com.zhenjiehan.community.entity.User;
import com.zhenjiehan.community.service.DiscussPostService;
import com.zhenjiehan.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    //page 中的 current 由页面传入 保留在 page 中
    public String getIndexPage(Model model, Page page){
        //首页显示所有帖子 , 故userId设置为 0
        page.setRows(discussPostService.findDiscussPostRows(0));
        //保存访问路径 , 在页面跳转时直接使用
        page.setPath("/index");

        /**
         * 起始行号可由 current 结合 limit 计算出
         * limit 可进行设置 , 这里采用默认值
         */
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null){
            //取出该页所有帖子 , 将每条帖子与其所属用户绑定存入 map 中
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        //将包含所有帖子信息的 list 集合返回给页面
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}

