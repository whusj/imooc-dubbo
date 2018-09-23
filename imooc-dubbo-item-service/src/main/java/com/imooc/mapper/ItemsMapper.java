package com.imooc.mapper;

import com.imooc.po.Items;
import org.apache.ibatis.annotations.*;

/**
 * User映射类
 * Created by Administrator on 2017/11/24.
 */
@Mapper
public interface ItemsMapper {
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "counts", column = "COUNTS")
    })


    @Insert("INSERT INTO ITEMS(NAME, COUNTS) VALUES(#{name}, #{counts})")
    int insert(Items record);

    @Select("SELECT * FROM ITEMS WHERE ID = #{id}")
    Items selectByPrimaryKey(@Param("id") String id);

    @Update("update items set counts=counts-#{buyCounts} where id=#{id}")
    int reduceCounts(Items record);
}
