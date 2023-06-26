package com.lvyouwangzhan.service;

import com.lvyouwangzhan.mapper.RoomMapper;
import com.lvyouwangzhan.pojo.Hotel;
import com.lvyouwangzhan.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    @Autowired
    private RoomMapper roomMapper;

    public Map<String, Object> listRoomByHotelId(Integer hotel_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Room> rooms = roomMapper.listRoomByHotelId(hotel_id);
            if (rooms.size()==0) {
                map.put("code", "501");
                map.put("msg", "获取房间列表失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取房间列表成功");
                map.put("data", rooms);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> listRoomById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Room room = roomMapper.listRoomById(id);
            if (room==null) {
                map.put("code", "501");
                map.put("msg", "获取房间失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取房间成功");
                map.put("data", room);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> insertRoom(Integer hotel_id, String name, String img, Double money, String tag, String information, String toiletries, String conveniences, String technology, String bathroom, String food, String other) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer rows = roomMapper.insertRoom(hotel_id, name, img, money, tag, information, toiletries, conveniences, technology, bathroom, food, other);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "新增房间失败");
            } else {
                map.put("code", "200");
                map.put("msg", "新增房间成功");
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> updateRoom(Integer id, Integer hotel_id, String name, String img, Double money, String tag, String information, String toiletries, String conveniences, String technology, String bathroom, String food, String other) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer rows = roomMapper.updateRoom(id, hotel_id, name, img, money, tag, information, toiletries, conveniences, technology, bathroom, food, other);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "修改房间失败");
            } else {
                map.put("code", "200");
                map.put("msg", "修改房间成功");
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> deleteRoom(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer rows = roomMapper.deleteRoom(id);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "删除房间失败");
            } else {
                map.put("code", "200");
                map.put("msg", "删除房间成功");
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }
}
