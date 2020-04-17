package com.example.demo.distance.dataObject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-16 16:40
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserGeohash {

    private Integer id;

    private String name;

    private Double longitude;

    private Double latitude;

    private String geoCode;

    private LocalDateTime createTime;

    /**
     * 距离
     */
    private Double distance;
}
