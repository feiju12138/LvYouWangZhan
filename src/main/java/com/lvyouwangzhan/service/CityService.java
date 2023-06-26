package com.lvyouwangzhan.service;

import com.lvyouwangzhan.mapper.CityMapper;
import com.lvyouwangzhan.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> listAllCity() {
        return cityMapper.listAllCity();
    }
}
