package com.endava.springhibernate;

import com.endava.springhibernate.dao.CarDao;
import com.endava.springhibernate.dao.WheelDao;
import com.endava.springhibernate.model.Car;
import com.endava.springhibernate.model.Wheel;
import com.endava.springhibernate.service.CarService;
import com.endava.springhibernate.service.CarServiceImpl;
import com.endava.springhibernate.service.WheelService;
import com.endava.springhibernate.service.WheelServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringHibernateApplication implements CommandLineRunner {
    @Autowired
    private WheelDao wheelDao;

    @Autowired
    private CarDao carDao;


    Logger logger= LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("New Collection of Wheels");
        Wheel wheel = new Wheel("car-wheel");
        wheelDao.save(wheel);

        Wheel wheel2=new Wheel("car-wheel");
        wheelDao.save(wheel2);

        Wheel wheel3=new Wheel("car-wheel");
        wheelDao.save(wheel3);

        Wheel wheel4=new Wheel("car-wheel");
        wheelDao.save(wheel4);


        // new list of wheels for a car
        List<Wheel> wheels=new ArrayList<>(4);
        wheels.add(wheel);
        wheels.add(wheel2);
        wheels.add(wheel3);
        wheels.add(wheel4);

        logger.info("New Car");
        Car car=new Car("Renault","Clio");
        car.setWheels(wheels);
        carDao.save(car);


        logger.info("New Collection of Winter Wheels");
        Wheel winterWheel=new Wheel("winter-wheel-1");
        wheelDao.save(winterWheel);
        Wheel winterWheel2=new Wheel("winter-wheel-2");
        wheelDao.save(winterWheel2);
        Wheel winterWheel3=new Wheel("winter-wheel-3");
        wheelDao.save(winterWheel3);
        Wheel winterWheel4=new Wheel("winter-wheel-4");
        wheelDao.save(winterWheel4);

        List<Wheel> winterWheels=new ArrayList<>(4);
        winterWheels.add(winterWheel);
        winterWheels.add(winterWheel2);
        winterWheels.add(winterWheel3);
        winterWheels.add(winterWheel4);

        logger.info("New Car with Winter Wheels");
        Car car2=new Car("Opel","Corsa");
        car.setWheels(winterWheels);
        carDao.save(car2);



        logger.info("Persist a car into the database");
        Car car3=new Car("Tesla","Teslax8");
        car3.setWheels(winterWheels);
        carDao.persist(car3);



        logger.info("Get a Car from the database");
        carDao.get(1L);

        logger.info("Load a Car from the database");
        carDao.load(2L);



//			Wheel wheel=new Wheel();
//			wheel.setName("1");
//			wheelService.save(wheel);
//
//			Wheel wheel2=new Wheel();
//			wheel2.setName("2");
//			wheelService.save(wheel2);
//
//			Wheel wheel3=new Wheel();
//			wheel3.setName("3");
//			wheelService.save(wheel3);
//
//			Wheel wheel4=new Wheel();
//			wheel4.setName("4");
//			wheelService.save(wheel4);
//
//
//			List<Wheel> wheels=new ArrayList<>();
//			wheels.add(wheel);
//			wheels.add(wheel2);
//			wheels.add(wheel3);
//			wheels.add(wheel4);
//
//
//
//			Car car=new Car("Renault","Clio");
//			car.setWheels(wheels);
//			carService.save(car);


    }
}
