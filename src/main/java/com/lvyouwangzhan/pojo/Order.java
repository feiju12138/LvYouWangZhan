package com.lvyouwangzhan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Integer id;
    private Integer user_id;
    private Integer room_id;
    private Date create_time;
    private Double money;
    private OrderInfo orderInfo;
    private Date start_time;
    private Date end_time;

}
