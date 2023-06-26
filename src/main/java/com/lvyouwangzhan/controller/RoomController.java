package com.lvyouwangzhan.controller;

import com.lvyouwangzhan.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 根据酒店编号获取房间列表
     * @param hotel_id 酒店编号
     * @return
     */
    @RequestMapping("/listRoomByHotelId")
    public Map<String, Object> listRoomByHotelId(Integer hotel_id) {
        return roomService.listRoomByHotelId(hotel_id);
    }

    /**
     * 根据房间编号获取房间信息
     * @param id 房间编号
     * @return
     */
    @RequestMapping("/listRoomById")
    public Map<String, Object> listRoomById(Integer id) {
        return roomService.listRoomById(id);
    }

    /**
     * 新增房间
     * @param hotel_id 酒店编号
     * @param name 房间名称
     * @param img 房间图片
     * @param money 房间价格
     * @param tag 房间标签
     * @param information 基本信息
     * @param toiletries 洗浴用品
     * @param conveniences 便利设施
     * @param technology 媒体科技
     * @param bathroom 浴室
     * @param food 食品饮品
     * @param other 其他设置
     * @return
     */
    @RequestMapping("/insertRoom")
    public Map<String, Object> insertRoom(Integer hotel_id, String name, String img, Double money, String tag, String information, String toiletries, String conveniences, String technology, String bathroom, String food, String other) {
        return roomService.insertRoom(hotel_id, name, img, money, tag, information, toiletries, conveniences, technology, bathroom, food, other);
    }

    /**
     * 修改房间
     * @param id 房间编号
     * @param hotel_id 酒店编号
     * @param name 房间名称
     * @param img 房间图片
     * @param money 房间价格
     * @param tag 房间标签
     * @param information 基本信息
     * @param toiletries 洗浴用品
     * @param conveniences 便利设施
     * @param technology 媒体科技
     * @param bathroom 浴室
     * @param food 食品饮品
     * @param other 其他设置
     * @return
     */
    @RequestMapping("/updateRoom")
    public Map<String, Object> updateRoom(Integer id, Integer hotel_id, String name, String img, Double money, String tag, String information, String toiletries, String conveniences, String technology, String bathroom, String food, String other) {
        return roomService.updateRoom(id, hotel_id, name, img, money, tag, information, toiletries, conveniences, technology, bathroom, food, other);
    }

    /**
     * 删除房间
     * @param id 房间编号
     * @return
     */
    @RequestMapping("/deleteRoom")
    public Map<String, Object> deleteRoom(Integer id) {
        return roomService.deleteRoom(id);
    }

}
