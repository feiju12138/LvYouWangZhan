package com.lvyouwangzhan.mapper;

import com.lvyouwangzhan.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM city")
    List<City> listAllCity();

    @Select("SELECT * FROM city WHERE name=#{name}")
    City listCityByName(String name);

    @Select("SELECT * FROM city WHERE id=#{id}")
    City listCityById(Integer id);
}
