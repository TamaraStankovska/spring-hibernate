package com.endava.springhibernate.service;


import com.endava.springhibernate.dao.WheelDao;
import com.endava.springhibernate.model.Wheel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WheelServiceImpl implements WheelService{

    @Autowired
    private WheelDao wheelDao;

    @Override
    public List<Wheel> findAll() {
        return wheelDao.findAll();
    }

    @Override
    public Wheel findById(Long id) {
        return wheelDao.findById(id);
    }

    @Override
    public void save(Wheel wheel) {

        wheelDao.save(wheel);
    }

    @Override
    public void delete(Wheel wheel) {
            wheelDao.delete(wheel);
    }
}
