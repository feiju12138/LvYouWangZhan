package com.lvyouwangzhan.pojo;

import lombok.Data;

@Data
public class Hotel {

    private Integer id;
    private Integer city_id;
    private String name;
    private String img;
    private String address;
    private String introduce;
    private Double score;

}
