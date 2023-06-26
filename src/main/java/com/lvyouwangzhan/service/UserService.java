package com.lvyouwangzhan.service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.lvyouwangzhan.mapper.UserMapper;
import com.lvyouwangzhan.pojo.ResponseResult;
import com.lvyouwangzhan.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private String redisPort;
    @Value("${spring.redis.password}")
    private String redisPassword;

    @Autowired
    private UserMapper userMapper;

    public ResponseResult register(String username, String code, String nickname, String password) {
        try {

            // 连接redis
            Jedis jedis = new Jedis(redisHost, Integer.parseInt(redisPort));
            jedis.auth(redisPassword);
            log.info("已经使用Jedis连接上了Redis");
            // 检验验证码
            if (jedis.get(username)==null || !code.equals(jedis.get(username))) {
                return new ResponseResult("503", "验证码有误");
            }

            // 检查用户名是否存在
            int count = userMapper.getUserCountByUsername(username);
            if (count!=0) {
                return new ResponseResult("502", "用户名已存在");
            }

            // 密码加密
            String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes());
            password = passwordMD5;

            // 添加用户信息到数据库
            int rows = userMapper.register(username, nickname, password);
            if (rows!=1) {
                return new ResponseResult("501", "添加用户到数据库失败");
            }
            return new ResponseResult("200", "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult("500", "后端程序报错");
        }
    }

    public Map<String, Object> login(String username, String password) {

        Map<String, Object> map = new HashMap<>();

        try {

            // 从数据获取用户信息
            User user = userMapper.listUserByUsername(username);

            if (user==null) {
                map.put("code", "502");
                map.put("msg", "用户不存在");
                return map;
            }

            // 密码加密
            String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes());
            password = passwordMD5;

            // 密码核对
            if (password.equals(user.getPassword())) {

                // 清空密码
                user.setPassword(null);

                map.put("code", "200");
                map.put("msg", "登录成功");
                map.put("data", user);
                return map;
            } else {
                System.out.println(password);
                map.put("code", "501");
                map.put("msg", "密码错误");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
            return map;
        }

    }

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private static final int APPID = 1400596163;
    private static final String APPKEY = "189f54fc71ed0ee82d167f271644a883";
    private static final int TEMPLATEID = 1200079;
    private static final String SMSSIGN = "共享相册som";

    public static void sendSMS(String phoneNumber, String code) throws Exception {
        // 短信应用SDK AppID   // 1400开头
        int appid = APPID;
        // 短信应用SDK AppKey
        String appkey = APPKEY;
        // 短信模板ID，需要在短信应用中申请
        int templateId =  TEMPLATEID;
        // 签名，使用的是`签名内容`，而不是`签名ID`
        String smsSign = SMSSIGN;
        // 参数，一定要对应短信模板中的参数顺序和个数，
        String[] params = {code};
        SmsSingleSender smsSingleSender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result = smsSingleSender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
        // 签名参数未提供或者为空时，会使用默认签名发送短信
        System.out.println(result.toString());
    }

    public void VerificationCodeResult(String username) throws Exception {
        // 产生一个四位数的随机数
        String randStr = Integer.toString(new Random().nextInt(10))+Integer.toString(new Random().nextInt(10))+Integer.toString(new Random().nextInt(10))+Integer.toString(new Random().nextInt(10));
        // 发送验证码
        sendSMS(username, randStr);
        log.info("验证码发送成功");
        // 连接redis
        Jedis jedis = new Jedis(redisHost, Integer.parseInt(redisPort));
        jedis.auth(redisPassword);
        log.info("已经使用Jedis连接上了Redis");
        // 检测是否存在，如果存在就删除旧的
        if (jedis.get(username)!=null) {
            jedis.del(username);
            log.info("检测到了旧的验证码，已删除");
        }
        // 写入redis
        jedis.setex(username, 300, randStr);
        log.info("验证码已存储在Redis: " + username + " - " + jedis.get(username));
    }

    public Map<String, Object> listUser() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<User> users = userMapper.listUser();
            if (users.size()==0) {
                map.put("code", "501");
                map.put("msg", "获取用户列表失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取用户列表成功");
                map.put("data", users);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> deleteUser(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer rows = userMapper.deleteUser(id);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "删除用户失败");
            } else {
                map.put("code", "200");
                map.put("msg", "删除用户成功");
            }
        } catch (Exception e) {
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> listUserById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            User user = userMapper.listUserById(id);
            if (user==null) {
                map.put("code", "501");
                map.put("msg", "获取用户信息失败");
            } else {
                map.put("code", "200");
                map.put("msg", "获取用户信息成功");
                map.put("data", user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> updateUser(Integer id, String nickname, Integer sex, String email) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer rows = userMapper.updateUser(id, nickname, sex, email);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "修改用户信息失败");
            } else {
                map.put("code", "200");
                map.put("msg", "修改用户信息成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> updateUserAvatar(Integer id, String avatar) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer rows = userMapper.updateUserAvatar(id, avatar);
            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "修改用户头像失败");
            } else {
                map.put("code", "200");
                map.put("msg", "修改用户头像成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "后端程序报错");
        }
        return map;
    }

    public Map<String, Object> updateUserPassword(Integer id, String password, String username, String code) {

        Map<String, Object> map = new HashMap<>();

        // 连接redis
        Jedis jedis = new Jedis(redisHost, Integer.parseInt(redisPort));
        jedis.auth(redisPassword);
        log.info("已经使用Jedis连接上了Redis");
        // 检验验证码
        if (jedis.get(username)==null || !code.equals(jedis.get(username))) {
            map.put("code", "502");
            map.put("msg", "验证码有误");
            return map;
        }

        try {

            // 密码加密
            String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes());
            password = passwordMD5;

            Integer rows = userMapper.updateUserPassword(id, password);

            if (rows==0) {
                map.put("code", "501");
                map.put("msg", "修改密码失败");
                return map;
            } else {
                map.put("code", "200");
                map.put("msg", "修改密码成功");
                return map;
            }

        } catch (Exception e) {
            map.put("code", "500");
            map.put("msg", "后端程序报错");
            return map;
        }


    }
}
