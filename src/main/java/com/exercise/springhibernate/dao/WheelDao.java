package com.exercise.springhibernate.dao;

import com.exercise.springhibernate.model.Wheel;

import java.util.List;


public interface WheelDao {
    List<Wheel> findAll();
    void save(Wheel wheel);
    void delete(Wheel wheel);
    Wheel findById(Long id);
    void persist(Wheel wheel);
    Wheel get(Long id);
    Wheel load(Long id);

}
