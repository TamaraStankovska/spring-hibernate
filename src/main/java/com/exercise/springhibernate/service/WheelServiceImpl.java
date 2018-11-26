package com.exercise.springhibernate.service;


import com.exercise.springhibernate.dao.WheelDao;
import com.exercise.springhibernate.model.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    @Override
    public void persist(Wheel wheel) {
        wheelDao.persist(wheel);
    }

    @Override
    public Wheel get(Long id) {
        return wheelDao.get(id);
    }

    @Override
    public Wheel load(Long id) {
        return wheelDao.load(id);
    }
}
