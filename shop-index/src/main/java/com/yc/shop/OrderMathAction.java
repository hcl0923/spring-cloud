package com.yc.shop;

import com.yc.shop.web.MathAction;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-12 21:00
 */
@RestController
public class OrderMathAction {

    private MathAction mathAction;

    //实例块==》无名称无参数的构造方法
    {
        try {
            //创建远程调用接口    JDK的动态代理
            mathAction = RPC.getProxy(MathAction.class, 1L,
                    new InetSocketAddress("127.0.0.1", 8399),
                    new Configuration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //与Feign对比
    @GetMapping("sub")
    public int sub(int a, int b) {
        return mathAction.sub(a, b);
    }

}
