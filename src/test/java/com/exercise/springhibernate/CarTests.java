package com.exercise.springhibernate;

import com.exercise.springhibernate.model.Car;
import com.exercise.springhibernate.model.Wheel;
import com.exercise.springhibernate.service.CarServiceImpl;
import com.exercise.springhibernate.service.WheelServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(locations = {"classpath:/hibernate.cfg.xml"})
public class CarTests{


    @Mock
    CarServiceImpl carService;

    @Mock
    WheelServiceImpl wheelService;





    @Test
    public void saveCar(){
        Wheel wheel=new Wheel("1");
        Wheel wheel2=new Wheel("2");
        Wheel wheel3=new Wheel("3");
        Wheel wheel4=new Wheel("4");
        wheelService.save(wheel);
        wheelService.save(wheel2);
        wheelService.save(wheel3);
        wheelService.save(wheel4);


        List<Wheel> wheels=new ArrayList<>();
        wheels.add(wheel);
        wheels.add(wheel2);
        wheels.add(wheel3);
        wheels.add(wheel4);

        Car car=new Car("Opel","Sth");
        car.setWheels(wheels);
        carService.save(car);

        Assert.assertEquals(car.getId(),carService.get(car.getId()));
    }


    @Test
    public void deleteCar(){
        Car car=carService.get(1L);
        carService.delete(car);

        Assert.assertNull(car);
    }




//    @Test
//    @Transactional
//    public void saveNewCar(){
//        Car car=carService.get(1L);
//        car.setType("Corsa**");
//
//        Car car1 = entityManager.merge(car);
//
//        Assert.assertNotEquals(car,car1);
//
//    }


//    @Test
//    public void saveCarMerge(){
//
//        Car car=new Car("Opel","Corsa");
//        carService.save(car);
//        entityManager.flush();
//
//
//        car.setType("Corsa x2");
//        entityManager.merge(car);
//
//        Assert.assertEquals(car.getType(),"Corsa x2");
//        //  Assert.assertEquals(car.getType(),"Corsa");
//
//    }
}
