package com.lvyouwangzhan.controller;

import com.lvyouwangzhan.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/attractions")
public class AttractionsController {

    @Autowired
    private AttractionsService attractionsService;

    /**
     * 根据城市编号获取景点列表
     * @param city_id 城市编号
     * @return
     */
    @RequestMapping("/listAttractions")
    public Map<String, Object> listAttractions(Integer city_id) {
        return attractionsService.listAttractions(city_id);
    }

}
