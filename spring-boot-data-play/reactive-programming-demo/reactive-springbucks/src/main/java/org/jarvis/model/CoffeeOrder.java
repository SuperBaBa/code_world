package org.jarvis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author marcus
 * @date 2020/8/9-8:08
 */
@Data
@Table(value = "T_COFFEE_ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeOrder implements Serializable {
    private Long id;
    private String customer;
    private OrderState state;
    private List<Coffee> items;
    private Date createTime;
    private Date updateTime;
}
