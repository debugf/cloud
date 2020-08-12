package com.debugf.springcloud.controller;

import com.debugf.springcloud.entities.CommonResult;
import com.debugf.springcloud.entities.Payment;
import com.debugf.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuxiang
 * @date 2020/8/11 11:33
 * @Email 905364660@qq.com
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        System.out.println("******插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "插入数据成功,serverPort: "+serverPort,result);
        }else {
            return new CommonResult(400,"插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("******查询结果：" + payment);
        if(payment != null){
            return new CommonResult(200, "查询成功,serverPort: "+serverPort,payment);
        }else {
            return new CommonResult(400,"没有ID为"+id+"的数据", null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("******element："+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
