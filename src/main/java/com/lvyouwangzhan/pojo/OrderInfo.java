package com.lvyouwangzhan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {

    private Integer hotel_id;
    private String hotel_name;
    private Integer room_id;
    private String room_name;
    private String room_img;
    private Double room_money;
    private String room_information;

}
