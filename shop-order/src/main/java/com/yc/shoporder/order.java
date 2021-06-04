package com.yc.shoporder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:26
 */
@RestController
public class order {

    @RequestMapping("order")
    public String order(HttpServletRequest request) {
        return "order:" + request.getLocalPort();
    }

}
