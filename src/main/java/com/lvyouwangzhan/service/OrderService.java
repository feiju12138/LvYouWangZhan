package com.lvyouwangzhan.service;

import com.lvyouwangzhan.mapper.OrderMapper;
import com.lvyouwangzhan.mapper.UserMapper;
import com.lvyouwangzhan.pojo.Order;
import com.lvyouwangzhan.pojo.OrderInfo;
import com.lvyouwangzhan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> listOrderByUserId(Integer user_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Order> orders = orderMapper.listOrderByUserId(user_id);

            if (orders.size()==0) {
                map.put("code", "501");
                map.put("msg", "获取订单列表失败");
                return map;
            }

            for (Order order : orders) {
                OrderInfo info = orderMapper.getInfoByRoomId(order.getRoom_id());
                order.setOrderInfo(info);
            }

            map.put("code", "200");
            map.put("msg", "获取订单列表成功");
            map.put("data", orders);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
            return map;
        }
    }

    public Map<String, Object> insertOrder(Integer user_id, Integer room_id, Double money, String start_time, String end_time) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 检测用户金额是否足够
            User user = userMapper.listUserById(user_id);
            if (user.getMoney()<money) {
                map.put("code", "502");
                map.put("msg", "用户余额不足");
                return map;
            }

            // 扣除用户金额
            userMapper.updateUserMoney(user_id, user.getMoney()-money);

            // 日期转换
            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date start_time_date;
            Date end_time_date;
            try {
                start_time_date = simpleDateFormat.parse(start_time);
                end_time_date = simpleDateFormat.parse(end_time);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("code", "503");
                map.put("msg", "日期转换失败");
                return map;
            }

            // 插入订单
            int rows = orderMapper.insertOrder(user_id, room_id, money, start_time_date, end_time_date);

            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "创建订单失败");
                return map;
            } else {
                map.put("code", "200");
                map.put("msg", "创建订单成功");
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "网络连接错误");
            return map;
        }
    }
}
