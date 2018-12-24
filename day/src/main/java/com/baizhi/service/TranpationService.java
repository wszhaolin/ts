package com.baizhi.service;

import com.baizhi.entity.Tranpation;

import java.util.List;

public interface TranpationService {
    public List<Tranpation> findAll();
    public void insert(Tranpation tranpation);
    public void delete(String id);
}
