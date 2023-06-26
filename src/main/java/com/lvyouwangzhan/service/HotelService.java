package com.lvyouwangzhan.service;

import com.lvyouwangzhan.mapper.HotelMapper;
import com.lvyouwangzhan.mapper.RoomMapper;
import com.lvyouwangzhan.pojo.Hotel;
import com.lvyouwangzhan.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private RoomMapper roomMapper;

    public Map<String, Object> listHotelByCityId(Integer city_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Hotel> hotels = hotelMapper.listHotelByCityId(city_id);
            if (hotels.size()==0) {
                map.put("code", "501");
                map.put("msg", "获取酒店列表失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取酒店列表成功");
                map.put("data", hotels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> listHotelById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Hotel hotel = hotelMapper.listHotelById(id);
            if (hotel==null) {
                map.put("code", "501");
                map.put("msg", "获取酒店失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取酒店成功");
                map.put("data", hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> insertHotel(Integer city_id, String name, String img, String address, String introduce, Double score) {
        Map<String, Object> map = new HashMap<>();
        try {
            int rows = hotelMapper.insertHotel(city_id, name, img, address, introduce, score);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "新增酒店失败");
                return map;
            }
            // 获取酒店编号
            List<Integer> hotels_id = hotelMapper.listHotelIdByHotelName(name);
            if (hotels_id.size()==0) {
                map.put("code", "503");
                map.put("msg", "酒店编号获取失败");
                return map;
            }
            Integer hotel_id = hotels_id.get(hotels_id.size()-1);
            // 获取图片数组
            ArrayList<String> arr = JSONUtil.toObject(img, ArrayList.class);
            if (arr.size()!=4) {
                map.put("code", "502");
                map.put("msg", "图片数量不够");
                return map;
            }
            roomMapper.insertRoom(hotel_id, "标准间", "[\""+arr.get(0)+"\"]", 488.0, "[\"标签1\", \"标签2\"]", "[\"56平方米\", \"2张单人床\", \"6楼\"]", "[\"牙刷\", \"牙膏\", \"沐浴露\", \"洗发水\", \"浴帽\", \"梳子\", \"毛巾\"]", "[\"坐卧两用长沙发\", \"房间内高速上网\", \"客房Wifi\", \"地暖\", \"遮光窗帘\", \"暖气\", \"手动窗帘\", \"空调\", \"沙发\", \"衣橱/衣柜\", \"熨衣设备\", \"书桌\", \"茶几\", \"休闲椅\", \"餐桌\", \"床具：毯子或被子\", \"电子秤\", \"洗衣机\", \"洗衣用品\", \"衣架\", \"多种规格电源插座\", \"220V电压插座\", \"雨伞\", \"独立淋浴间\", \"独立卫生间\", \"吹风机\", \"浴巾\", \"24小时热水\", \"电热水器\", \"拖鞋\", \"卫生纸\"]", "[\"电话\", \"液晶电视机\", \"有线频道\", \"按次点播收费电视\", \"智能门锁\"]", "[\"独立淋浴间\", \"独立卫生间\", \"吹风机\", \"浴巾\", \"24小时热水\", \"电热水器\", \"拖鞋\", \"卫生纸\"]", "[\"餐具\", \"瓶装水\", \"电热水壶\"]", "[\"刷卡进门\", \"挂墙装饰画/字画\"]");
            roomMapper.insertRoom(hotel_id, "大床房", "[\""+arr.get(1)+"\"]", 699.0, "[\"标签1\", \"标签2\"]", "[\"82平方米\", \"1张双人床\", \"2楼\"]", "[\"牙刷\", \"牙膏\", \"沐浴露\", \"洗发水\", \"浴帽\", \"梳子\", \"毛巾\"]", "[\"坐卧两用长沙发\", \"房间内高速上网\", \"客房Wifi\", \"地暖\", \"遮光窗帘\", \"暖气\", \"手动窗帘\", \"空调\", \"沙发\", \"衣橱/衣柜\", \"熨衣设备\", \"书桌\", \"茶几\", \"休闲椅\", \"餐桌\", \"床具：毯子或被子\", \"电子秤\", \"洗衣机\", \"洗衣用品\", \"衣架\", \"多种规格电源插座\", \"220V电压插座\", \"雨伞\", \"独立淋浴间\", \"独立卫生间\", \"吹风机\", \"浴巾\", \"24小时热水\", \"电热水器\", \"拖鞋\", \"卫生纸\"]", "[\"电话\", \"液晶电视机\", \"有线频道\", \"按次点播收费电视\", \"智能门锁\"]", "[\"独立淋浴间\", \"独立卫生间\", \"吹风机\", \"浴巾\", \"24小时热水\", \"电热水器\", \"拖鞋\", \"卫生纸\"]", "[\"餐具\", \"瓶装水\", \"电热水壶\"]", "[\"刷卡进门\", \"挂墙装饰画/字画\"]");
            roomMapper.insertRoom(hotel_id, "特价房", "[\""+arr.get(2)+"\"]", 599.0, "[\"标签1\", \"标签2\"]", "[\"118平方米\", \"1张双人床，1张单人床\", \"4楼\"]", "[\"牙刷\", \"牙膏\", \"沐浴露\", \"洗发水\", \"浴帽\", \"梳子\", \"毛巾\"]", "[\"坐卧两用长沙发\", \"房间内高速上网\", \"客房Wifi\", \"地暖\", \"遮光窗帘\", \"暖气\", \"手动窗帘\", \"空调\", \"沙发\", \"衣橱/衣柜\", \"熨衣设备\", \"书桌\", \"茶几\", \"休闲椅\", \"餐桌\", \"床具：毯子或被子\", \"电子秤\", \"洗衣机\", \"洗衣用品\", \"衣架\", \"多种规格电源插座\", \"220V电压插座\", \"雨伞\", \"独立淋浴间\", \"独立卫生间\", \"吹风机\", \"浴巾\", \"24小时热水\", \"电热水器\", \"拖鞋\", \"卫生纸\"]", "[\"电话\", \"液晶电视机\", \"有线频道\", \"按次点播收费电视\", \"智能门锁\"]", "[\"独立淋浴间\", \"独立卫生间\", \"吹风机\", \"浴巾\", \"24小时热水\", \"电热水器\", \"拖鞋\", \"卫生纸\"]", "[\"餐具\", \"瓶装水\", \"电热水壶\"]", "[\"刷卡进门\", \"挂墙装饰画/字画\"]");

            map.put("code", "200");
            map.put("msg", "酒店插入成功，默认房间添加成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
            return map;
        }

    }

    public Map<String, Object> updateHotel(Integer id, Integer city_id, String name, String img, String address, String introduce, Double score) {
        Map<String, Object> map = new HashMap<>();
        try {
            int rows = hotelMapper.updateHotel(id, city_id, name, img, address, introduce, score);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "修改酒店失败");
            } else {
                map.put("code", "200");
                map.put("msg", "修改酒店成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> deleteHotel(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            int rows = hotelMapper.deleteHotel(id);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "删除酒店失败");
            } else {
                map.put("code", "200");
                map.put("msg", "删除酒店成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }
}
