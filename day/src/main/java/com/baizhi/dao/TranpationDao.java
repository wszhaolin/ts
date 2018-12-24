package com.baizhi.dao;

import com.baizhi.entity.Tranpation;

import java.util.List;

public interface TranpationDao {
    public List<Tranpation> queryAll();
    public void insert(Tranpation tranpation);
    public void delete(String id);
}
