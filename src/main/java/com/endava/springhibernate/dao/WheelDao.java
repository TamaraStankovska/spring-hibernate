package com.endava.springhibernate.dao;

import com.endava.springhibernate.model.Wheel;

import java.util.List;

public interface WheelDao {
    List<Wheel> findAll();
    void save(Wheel wheel);
    void delete(Wheel wheel);

    Wheel findById(Long id);
}
