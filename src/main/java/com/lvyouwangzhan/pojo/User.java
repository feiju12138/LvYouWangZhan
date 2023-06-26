package com.lvyouwangzhan.pojo;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private Integer type;
    private Double money;
    private Integer sex;
    private String email;
    private String avatar;

}
