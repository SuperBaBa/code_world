package org.jarvis.converter;

import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * 向dataBase写入是，将{@link Money}类型转换成
 * author:marcus date:2020/8/3
 **/
public class MoneyWriteConverter implements Converter<Money, Long> {
    @Override
    public Long convert(Money money) {
        return money.getAmountMinorLong();
    }
}
