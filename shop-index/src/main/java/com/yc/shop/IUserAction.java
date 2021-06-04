package com.yc.shop;

import com.yc.shop.bean.Result;
import com.yc.shop.bean.User;
import com.yc.shop.web.UserActionImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: shop-index
 * @description:调用User服务网元接口--》shop-user
 * @author: 作者
 * @create: 2021-05-09 09:23
 */
@FeignClient(value = "shop-user", fallback = UserActionImpl.class)  //同一个服务网元不能定义多个接口
public interface IUserAction {
    //定义目标网元的资源路径
    @GetMapping("user")
    String user(HttpServletRequest req, HttpServletResponse resp);

    // Method has too many Body parameters: public abstract int com.yc .shop.IUserAction .add(int,
    // body请求体Feign默认会将每个方法参数视为请求体
    @GetMapping("add")
    int add(@RequestParam int a, @RequestParam int b);

    @PostMapping("login")
    Result login(User user);

}
