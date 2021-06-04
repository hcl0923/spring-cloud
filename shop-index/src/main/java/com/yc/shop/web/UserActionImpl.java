package com.yc.shop.web;

import com.yc.shop.IUserAction;
import com.yc.shop.bean.Result;
import com.yc.shop.bean.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:23
 */

//降级实现类
@Component
public class UserActionImpl implements IUserAction {

    @Override
    public String user(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(Arrays.toString(req.getCookies()));
        System.out.println("Cookie:" + req.getHeader("Cookie"));
        Enumeration<String> hs = req.getHeaderNames();
        while (hs.hasMoreElements()) {
            String name = hs.nextElement();
            System.out.println(name + " :\t" + req.getHeader(name));
        }
        resp.addCookie(new Cookie("b", "200"));
        return "user 熔断";
    }

    @Override
    public int add(int a, int b) {
        return a + b + 10000;
    }

    @Override
    public Result login(User user) {
        user.setName(user.getName() + "降级");
        return new Result(-1, "login降级", user);
    }
}
