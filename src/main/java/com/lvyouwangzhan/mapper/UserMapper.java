package com.lvyouwangzhan.mapper;

import com.lvyouwangzhan.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT COUNT(*) FROM user WHERE username=#{username}")
    Integer getUserCountByUsername(String username);

    @Insert("INSERT INTO user VALUES (null, #{username}, #{nickname}, #{password}, 1, 0, 1, null, '//pic.imgdb.cn/item/61a59d382ab3f51d91a72a49.png')")
    Integer register(String username, String nickname, String password);

    @Select("SELECT id, username, nickname, password, money, sex, email, avatar FROM user WHERE username=#{username}")
    User listUserByUsername(String username);

    @Select("SELECT id, username, nickname, money, sex, email, avatar FROM user WHERE type!=0")
    List<User> listUser();

    @Delete("DELETE FROM user WHERE id=#{id}")
    Integer deleteUser(Integer id);

    @Select("SELECT id, username, nickname, money, sex, email, avatar FROM user WHERE id=#{id}")
    User listUserById(Integer id);

    @Update("UPDATE user SET nickname=#{nickname}, sex=#{sex}, email=#{email} WHERE id=#{id}")
    Integer updateUser(Integer id, String nickname, Integer sex, String email);

    @Update("UPDATE user SET avatar=#{avatar} WHERE id=#{id}")
    Integer updateUserAvatar(Integer id, String avatar);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    Integer updateUserPassword(Integer id, String password);

    @Update("UPDATE user SET money=#{money} WHERE id=#{id}")
    Integer updateUserMoney(Integer id, Double money);
}
