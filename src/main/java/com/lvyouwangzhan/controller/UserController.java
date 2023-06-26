package com.lvyouwangzhan.controller;

import com.lvyouwangzhan.pojo.ResponseResult;
import com.lvyouwangzhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("/register")
    public ResponseResult register(String username, String code, String nickname, String password) {
        return userService.register(username, code, nickname, password);
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/login")
    public Map<String, Object> login(String username, String password) {
        return userService.login(username, password);
    }

    /**
     * 发送验证码
     * @return
     */
    @RequestMapping("/verificationCode")
    public ResponseResult verificationCode(String username) {
        try {
            userService.VerificationCodeResult(username);
            return new ResponseResult("200", "验证码发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult("500", "验证码发送失败");
        }
    }


    // 管理员的操作
    /**
     * 获取所有用户列表
     * @return
     */
    @RequestMapping("/listUser")
    public Map<String, Object> listUser() {
        return userService.listUser();
    }

    /**
     * 删除用户
     * @param id 用户编号
     * @return
     */
    @RequestMapping("/deleteUser")
    public Map<String, Object> deleteUser(Integer id) {
        return userService.deleteUser(id);
    }


    // 用户自己的操作
    /**
     * 根据用户编号获取用户全部信息
     * @param id 用户编号
     * @return
     */
    @RequestMapping("/listUserById")
    public Map<String, Object> listUserById(Integer id) {
        return userService.listUserById(id);
    }

    /**
     * 修改用户信息
     * @param id 用户编号
     * @param nickname 昵称
     * @param sex 性别
     * @param email 电子邮箱
     * @return
     */
    @RequestMapping("/updateUser")
    public Map<String, Object> updateUser(Integer id, String nickname, Integer sex, String email) {
        return userService.updateUser(id, nickname, sex, email);
    }

    /**
     * 修改用户头像
     * @param id 用户编号
     * @param avatar 头像
     * @return
     */
    @RequestMapping("/updateUserAvatar")
    public Map<String, Object> updateUserAvatar(Integer id, String avatar) {
        return userService.updateUserAvatar(id, avatar);
    }

    /**
     * 修改用户密码
     * @param id 用户编号
     * @param password 新密码
     * @param username 手机号
     * @param code 验证码
     * @return
     */
    @RequestMapping("/updateUserPassword")
    public Map<String, Object> updateUserPassword(Integer id, String password, String username, String code) {
        return userService.updateUserPassword(id, password, username, code);
    }

}
