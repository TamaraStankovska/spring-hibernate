package com.endava.springhibernate.service;

import com.endava.springhibernate.dao.CarDao;
import com.endava.springhibernate.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
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

    @Override
    public void persist(Car car) {
        carDao.persist(car);
    }

    @Override
    public Car get(Long id) {
        return carDao.get(id);
    }

    @Override
    public Car load(Long id) {
        return carDao.load(id);
    }
}
