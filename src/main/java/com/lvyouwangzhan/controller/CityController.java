package com.lvyouwangzhan.controller;

import com.lvyouwangzhan.pojo.City;
import com.lvyouwangzhan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 获取所有城市
     * @return
     */
    @RequestMapping("/listAllCity")
    public Map<String, Object> listAllCity() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<City> cities = cityService.listAllCity();
            map.put("code", "200");
            map.put("data", cities);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

}
