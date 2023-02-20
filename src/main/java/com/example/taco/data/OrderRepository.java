package com.example.taco.data;


import com.example.taco.TacoOrder;
import com.example.taco.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository
        extends CrudRepository<TacoOrder, UUID> {
    // 根据DeliveryZip查询order
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    // 获取PlacedAt在startDate和endDate之间的，符合deliveryZip的订单
    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);


    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}