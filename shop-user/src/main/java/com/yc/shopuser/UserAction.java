package com.yc.shopuser;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:26
 */
@RestController

public class UserAction {

    @RequestMapping("user")
    public String user(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(Arrays.toString(req.getCookies()));
        System.out.println("Cookie:" + req.getHeader("Cookie"));
        Enumeration<String> hs = req.getHeaderNames();
        while (hs.hasMoreElements()) {
            String name = hs.nextElement();
            System.out.println(name + " :\t" + req.getHeader(name));
        }
        resp.addCookie(new Cookie("b", "200"));

        return "user:" + req.getLocalPort();
    }

    @GetMapping("add")
    public int add(int a, int b) {
        return a + b;
    }

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        return new Result(1, "success", user);
    }
}
