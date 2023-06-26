package com.lvyouwangzhan.pojo;

import lombok.Data;

@Data
public class Room {

    private Integer id;
    private Integer hotel_id;
    private String name;
    private String img;
    private Double money;
    private String tag;
    private String information;
    private String toiletries;
    private String conveniences;
    private String technology;
    private String bathroom;
    private String food;
    private String other;

}
