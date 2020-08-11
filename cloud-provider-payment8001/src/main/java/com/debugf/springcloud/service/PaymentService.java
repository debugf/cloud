package com.debugf.springcloud.service;

import com.debugf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuxiang
 * @date 2020/8/11 11:26
 * @Email 905364660@qq.com
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
