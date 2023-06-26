package com.lvyouwangzhan.controller;

import com.lvyouwangzhan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据用户编号获取订单列表
     * @param user_id 用户编号
     * @return
     */
    @RequestMapping("/listOrderByUserId")
    public Map<String, Object> listOrderByUserId(Integer user_id) {
        return orderService.listOrderByUserId(user_id);
    }

    /**
     * 插入订单
     * @param user_id 用户编号
     * @param room_id 房间编号
     * @param money 订单价格
     * @return
     */
    @RequestMapping("/insertOrder")
    public Map<String, Object> insertOrder(Integer user_id, Integer room_id, Double money, String start_time, String end_time) {
        return orderService.insertOrder(user_id, room_id, money, start_time, end_time);
    }

}
