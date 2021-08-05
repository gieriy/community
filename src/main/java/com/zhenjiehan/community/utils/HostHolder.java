package com.zhenjiehan.community.utils;

import com.zhenjiehan.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * 保存用户信息 , 代替 session 对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();
    public void setUsers(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
