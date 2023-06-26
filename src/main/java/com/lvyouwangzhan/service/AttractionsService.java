package com.lvyouwangzhan.service;

import com.lvyouwangzhan.mapper.AttractionsMapper;
import com.lvyouwangzhan.pojo.Attractions;
import com.lvyouwangzhan.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttractionsService {

    @Autowired
    private AttractionsMapper attractionsMapper;

    public Map<String, Object> listAttractions(Integer city_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Attractions> attractions = attractionsMapper.listAttractions(city_id);
            if (attractions.size()==0) {
                map.put("code", "501");
                map.put("msg", "获取酒店列表失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取酒店列表成功");
                map.put("data", attractions);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }
}
