package org.jarvis.model;

import lombok.*;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author tennyson
 * @date 2020/8/8-22:50
 */
@Table(name = "T_COFFEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Coffee extends BaseEntity {
    private String name;
    private Money price;
}
