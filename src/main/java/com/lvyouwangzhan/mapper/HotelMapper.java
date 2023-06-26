package com.lvyouwangzhan.mapper;

import com.lvyouwangzhan.pojo.Hotel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HotelMapper {

    @Select("SELECT * FROM hotel WHERE city_id=#{city_id} ORDER BY id DESC")
    List<Hotel> listHotelByCityId(Integer city_id);

    @Select("SELECT * FROM hotel WHERE id=#{id}")
    Hotel listHotelById(Integer id);

    @Insert("INSERT INTO hotel VALUES(null, #{city_id}, #{name}, #{img}, #{address}, #{introduce}, #{score})")
    Integer insertHotel(Integer city_id, String name, String img, String address, String introduce, Double score);

    @Select("SELECT id FROM hotel WHERE name=#{name}")
    List<Integer> listHotelIdByHotelName(String name);

    @Update("UPDATE hotel SET city_id=#{city_id}, name=#{name}, img=#{img}, address=#{address}, introduce=#{introduce}, score=#{score} WHERE id=#{id}")
    Integer updateHotel(Integer id, Integer city_id, String name, String img, String address, String introduce, Double score);

    @Delete("DELETE FROM hotel WHERE id=#{id}")
    Integer deleteHotel(Integer id);
}
