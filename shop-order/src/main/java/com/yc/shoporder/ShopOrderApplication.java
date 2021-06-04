package com.yc.shoporder;

import com.yc.shop.web.MathAction;
import com.yc.shoporder.web.MathActionImpl;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
public class ShopOrderApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(ShopOrderApplication.class, args);

        //启动Hadoop服务器  Configuration 配置对象，链式调用

        Server server = new RPC.Builder(new Configuration())
                .setProtocol(MathAction.class)
                /*设置接口类*/
                .setInstance(new MathActionImpl())
                //设置接口实现类
                .setBindAddress("127.0.0.1")
                //绑定地址
                .setPort(8399)
                //设置端口
                .setNumHandlers(5)
                //代理实例数量
                .build();                         //构建服务器
        server.start();

    }
}
