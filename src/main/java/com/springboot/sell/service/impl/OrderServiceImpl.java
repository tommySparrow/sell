package com.springboot.sell.service.impl;

import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/12/3
 * @ Description：
 * @ throws
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
