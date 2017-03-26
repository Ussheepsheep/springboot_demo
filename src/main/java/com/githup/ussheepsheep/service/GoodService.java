package com.githup.ussheepsheep.service;

import com.githup.ussheepsheep.domain.Good;
import com.githup.ussheepsheep.persistence.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by daren on 2017/2/14.
 */
@Service
public class GoodService {

    @Autowired
    private GoodMapper goodMapper;

    public List<Good> findAll() {
        return goodMapper.findAll();
    }

    @Transactional
    public boolean saveOne(String name, String desc) {
        goodMapper.saveOne(name, desc);
        return true;
    }
}
