package com.endava.springhibernate.dao;

import com.endava.springhibernate.model.Car;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> findAll() {
        Session session=sessionFactory.openSession();

        CriteriaBuilder builder=session.getCriteriaBuilder();

        CriteriaQuery<Car> criteriaQuery=builder.createQuery(Car.class);


        criteriaQuery.from(Car.class);


        List<Car> cars=session.createQuery(criteriaQuery).getResultList();
        session.close();

        return cars;
    }

    @Override
    public Car findById(Long id) {

        Session session=sessionFactory.openSession();
        Car car=session.get(Car.class,id);
        Hibernate.initialize(car.getId());
        session.close();
        return car;
    }

    @Override
    public void save(Car car) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(car);

        session.getTransaction().commit();

        session.close();

    }

    @Override
    public void delete(Car car) {

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(car);

        session.getTransaction().commit();
        session.close();

    }
}
