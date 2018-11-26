package com.endava.springhibernate.service;

import com.endava.springhibernate.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findById(Long id);
    void save(Car car);
    void delete(Car car);
}
