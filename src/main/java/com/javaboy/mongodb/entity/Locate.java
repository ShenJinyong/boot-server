package com.javaboy.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：定位信息
 * @date ：2022/11/14 16:49
 */
// 对应serverboot集合中的一个文档
@Document("locate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locate {

    @Field("object_id")
    private String objectId;

    @Field("imei")
    private String imei;

    @Field("type")
    private String type;

    @Field("jd")
    private Double jd;

    @Field("wd")
    private Double wd;

    @Field("address")
    private String address;

    @Field("locate_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date locateTime;

}
