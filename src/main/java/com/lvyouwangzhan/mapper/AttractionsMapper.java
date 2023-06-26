package com.lvyouwangzhan.mapper;

import com.lvyouwangzhan.pojo.Attractions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttractionsMapper {

    @Select("SELECT * FROM attractions WHERE city_id=#{city_id}")
    List<Attractions> listAttractions(Integer city_id);
}
