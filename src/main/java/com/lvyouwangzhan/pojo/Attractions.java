package com.lvyouwangzhan.pojo;

import lombok.Data;

@Data
public class Attractions {

    private Integer id;
    private Integer city_id;
    private String name;
    private String img;
    private Double money;
    private String introduce;
    private Double score;

}
