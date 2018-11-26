package com.endava.springhibernate.service;

import com.endava.springhibernate.model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findById(Long id);
    void save(Car car);
    void delete(Car car);
    void persist(Car car);
    Car get(Long id);
    Car load(Long id);

}
