package com.baizhi.service;

import com.baizhi.dao.TranpationDao;
import com.baizhi.entity.Tranpation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TranpationServiceImp implements TranpationService{
    @Autowired
    private TranpationDao tranpationDao;

    @Override
    @Transactional
    public List<Tranpation> findAll() {
        return tranpationDao.queryAll();
    }

    @Override
    public void insert(Tranpation tranpation) {
        tranpationDao.insert(tranpation);
    }

    @Override
    public void delete(String id) {
        tranpationDao.delete(id);
    }
}
