package com.yc.shop;

import com.yc.shop.bean.Result;
import com.yc.shop.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:26
 */
@RestController

public class index {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @Resource
    //    @LoadBalanced
    private RestTemplate restTemplate;

    //    @HystrixCommand(fallbackMethod = "myUser")
    @GetMapping("user")
    public String user() {
        String url = "http://shop-user/user";
        String ret = restTemplate.getForObject(url, String.class);
        //获取shop-user/user信息
        return "user:" + ret;
    }

    public String myUser() {
        return "myUser";
    }

    @GetMapping("order")
    public String order(HttpServletResponse response) {
        String url = "http://shop-order/order";
        String ret = restTemplate.getForObject(url, String.class);
        //获取shop-order/order信息
        return "order:" + ret;
    }

    ////////////feign 声明式服务调用//////////////
    @Resource
    private IUserAction userAction;

    @GetMapping("user1")
    public String userForFeign(HttpServletResponse response, HttpServletRequest request) {
        return userAction.user(request, response);
    }

    @GetMapping("add")
    public int add(int c, int d) {
        return userAction.add(c, d);
    }

    @PostMapping("login")
    public Result login(User user) {
        return userAction.login(user);
    }
}
