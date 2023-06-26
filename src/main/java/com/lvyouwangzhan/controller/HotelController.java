package com.lvyouwangzhan.controller;

import com.lvyouwangzhan.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * 根据城市编号获取酒店列表
     * @param city_id 城市编号
     * @return
     */
    @RequestMapping("/listHotelByCityId")
    public Map<String, Object> listHotelByCityId(Integer city_id) {
        return hotelService.listHotelByCityId(city_id);
    }

    /**
     * 根据酒店编号获取酒店信息
     * @param id 酒店编号
     * @return
     */
    @RequestMapping("/listHotelById")
    public Map<String, Object> listHotelById(Integer id) {
        return hotelService.listHotelById(id);
    }


    /**
     * 插入酒店
     * @param city_id 城市编号
     * @param name 酒店名称
     * @param img 酒店图片
     * @param address 酒店地址
     * @param introduce 酒店介绍
     * @param score 酒店评分
     * @return
     */
    @RequestMapping("/insertHotel")
    public Map<String, Object> insertHotel(Integer city_id, String name, String img, String address, String introduce, Double score) {
        return hotelService.insertHotel(city_id, name, img, address, introduce, score);
    }

    /**
     * 修改酒店
     * @param id 酒店编号
     * @param city_id 城市编号
     * @param name 酒店名称
     * @param img 酒店图片
     * @param address 酒店地址
     * @param introduce 酒店介绍
     * @param score 酒店评分
     * @return
     */
    @RequestMapping("/updateHotel")
    public Map<String, Object> updateHotel(Integer id, Integer city_id, String name, String img, String address, String introduce, Double score) {
        return hotelService.updateHotel(id, city_id, name, img, address, introduce, score);
    }

    /**
     * 删除酒店
     * @param id 酒店编号
     * @return
     */
    @RequestMapping("/deleteHotel")
    public Map<String, Object> deleteHotel(Integer id) {
        return hotelService.deleteHotel(id);
    }

}
