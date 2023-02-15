package com.example.taco.data;


import org.springframework.data.repository.CrudRepository;

import com.example.taco.TacoOrder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository
        extends CrudRepository<TacoOrder, UUID> {
    // 根据DeliveryZip查询order
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    // 获取PlacedAt在startDate和endDate之间的，符合deliveryZip的订单
    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);


}