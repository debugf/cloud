package com.debugf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author liuxiang
 * @date 2020/8/13 15:44
 * @Email 905364660@qq.com
 */
@RestController
public class PaymentControler {

    @Value("{server.port}")
    private String serverPort;
    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
