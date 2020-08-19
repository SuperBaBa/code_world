package org.jarvis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * author:marcus date:2020/7/9
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeOrder {
    private Long id;
    private List<Coffee> items;
    private Date updateTime;
    @Column(updatable = false)
    private Date createTime;
}
