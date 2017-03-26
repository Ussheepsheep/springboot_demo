package com.githup.ussheepsheep.persistence.mapper;

import com.githup.ussheepsheep.domain.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by daren on 2017/2/14.
 */
@Mapper
public interface GoodMapper {

    List<Good> findAll();

    int saveOne(@Param("name") String name, @Param("goodDesc") String desc);
}
