package com.springboot.sell.repository;

import com.springboot.sell.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    //buyerOpenid:买家微信Openid
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
