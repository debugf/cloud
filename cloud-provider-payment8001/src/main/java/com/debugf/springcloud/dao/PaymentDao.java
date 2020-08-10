package com.debugf.springcloud.dao;

import com.debugf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuxiang
 * @date 2020/8/10 20:44
 * @Email 905364660@qq.com
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
