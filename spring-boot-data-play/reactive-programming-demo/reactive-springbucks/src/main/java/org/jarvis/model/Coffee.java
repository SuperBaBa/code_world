package org.jarvis.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.jarvis.serializer.MoneyDeserializer;
import org.jarvis.serializer.MoneySerializer;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @author tennyson
 * @date 2020/8/8-22:50
 */
@Table(value = "T_COFFEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee implements Serializable {
    @Id
    private Long id;
    private String name;
    @JsonSerialize(using = MoneySerializer.class)
    @JsonDeserialize(using = MoneyDeserializer.class)
    private Money price;
    private Date createTime;
    private Date updateTime;
}
