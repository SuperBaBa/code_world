package com.jarvis.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * author:marcus date:2020/7/31
 **/
@Data
@Builder
@NoArgsConstructor
public class Students {
    private int id;
    private String name;
    private int coursesId;
    private Date createTime;
    private Date updateTime;
}
