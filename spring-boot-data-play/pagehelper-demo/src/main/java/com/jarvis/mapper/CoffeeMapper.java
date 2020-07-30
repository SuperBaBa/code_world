package com.jarvis.mapper;

import com.jarvis.model.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface CoffeeMapper {
    @Select(value = {"select * from t_coffee order by id"})
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    @Select(value = {"select * from t_coffee order by id"})
    List<Coffee> findAllWithParam(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);
}
