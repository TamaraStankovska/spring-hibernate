package com.exercise.springhibernate.service;

import com.exercise.springhibernate.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findById(Long id);
    void save(Car car);
    void delete(Car car);
    void persist(Car car);
    Car get(Long id);
    Car load(Long id);
    Car getTypeByName(String name);

}
