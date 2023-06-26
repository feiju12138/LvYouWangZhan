package com.lvyouwangzhan.mapper;

import com.lvyouwangzhan.pojo.Order;
import com.lvyouwangzhan.pojo.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM orders WHERE user_id=#{user_id}")
    List<Order> listOrderByUserId(Integer user_id);

    @Select("SELECT hotel.id AS hotel_id, hotel.name AS hotel_name, room.id AS room_id, room.name AS room_name, room.img AS room_img, room.money AS room_money, room.information AS room_information FROM hotel, room WHERE room.hotel_id=hotel.id AND room.id=#{room_id}")
    OrderInfo getInfoByRoomId(Integer room_id);

    @Insert("INSERT INTO orders VALUES(null, #{user_id}, #{room_id}, now(), #{money}, #{start_time}, #{end_time})")
    Integer insertOrder(Integer user_id, Integer room_id, Double money, Date start_time, Date end_time);
}
