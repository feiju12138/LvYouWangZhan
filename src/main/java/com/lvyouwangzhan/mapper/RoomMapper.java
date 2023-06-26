package com.lvyouwangzhan.mapper;

import com.lvyouwangzhan.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Select("SELECT * FROM room WHERE hotel_id=#{hotel_id}")
    List<Room> listRoomByHotelId(Integer hotel_id);

    @Select("SELECT * FROM room WHERE id=#{id}")
    Room listRoomById(Integer id);

    @Insert("INSERT INTO room VALUES(null, #{hotel_id}, #{name}, #{img}, #{money}, #{tag}, #{information}, #{toiletries}, #{conveniences}, #{technology}, #{bathroom}, #{food}, #{other})")
    Integer insertRoom(Integer hotel_id, String name, String img, Double money, String tag, String information, String toiletries, String conveniences, String technology, String bathroom, String food, String other);

    @Update("UPDATE room SET hotel_id=#{hotel_id}, name=#{name}, img=#{img}, money=#{money}, tag=#{tag}, information=#{information}, toiletries=#{toiletries}, conveniences=#{conveniences}, technology=#{technology}, bathroom=#{bathroom}, food=#{food}, other=#{other} WHERE id=#{id}")
    Integer updateRoom(Integer id, Integer hotel_id, String name, String img, Double money, String tag, String information, String toiletries, String conveniences, String technology, String bathroom, String food, String other);

    @Delete("DELETE FROM room WHERE id=#{id}")
    Integer deleteRoom(Integer id);
}
