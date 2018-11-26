package com.endava.springhibernate.dao;

import com.endava.springhibernate.model.Car;

import java.util.List;
public interface CarDao {
    List<Car> findAll();
    Car findById(Long id);
    void save(Car car);
    void delete(Car car);
    void persist(Car car);
    Car get(Long id);
    Car load(Long id);
}
