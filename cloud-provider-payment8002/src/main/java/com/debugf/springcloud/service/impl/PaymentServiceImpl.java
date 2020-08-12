package com.debugf.springcloud.service.impl;

import com.debugf.springcloud.dao.PaymentDao;
import com.debugf.springcloud.entities.Payment;
import com.debugf.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuxiang
 * @date 2020/8/11 11:27
 * @Email 905364660@qq.com
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
