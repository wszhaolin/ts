package com.baizhi.service;

import com.baizhi.dao.PoetriesDao;
import com.baizhi.entity.Poetries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PoetriesServiceImp implements PoetriesService{
    @Autowired
    private PoetriesDao poetriesDao;
    @Override
    public List<Poetries> queryAll() {
        return poetriesDao.findAll();
    }
}
