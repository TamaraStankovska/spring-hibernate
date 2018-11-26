package com.endava.springhibernate.service;

import com.endava.springhibernate.dao.CarDao;
import com.endava.springhibernate.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;


    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carDao.findById(id);
    }

    @Override
    public void save(Car car) {

        carDao.save(car);

    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }
}
