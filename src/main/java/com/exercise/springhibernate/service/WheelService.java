package com.exercise.springhibernate.service;

import com.exercise.springhibernate.model.Wheel;

import java.util.List;
public interface WheelService {
    List<Wheel> findAll();
    Wheel findById(Long id);
    void save(Wheel wheel);
    void delete(Wheel wheel);
    void persist(Wheel wheel);
    Wheel get(Long id);
    Wheel load(Long id);

}
