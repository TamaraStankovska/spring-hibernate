package com.exercise.springhibernate.dao;

import com.exercise.springhibernate.model.Car;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import org.hibernate.query.Query;
@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> findAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);


        criteriaQuery.from(Car.class);


        List<Car> cars = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return cars;
    }

    @Override
    public Car findById(Long id) {

        Session session = sessionFactory.openSession();
        Car car = session.get(Car.class, id);
        Hibernate.initialize(car.getId());
        session.close();
        return car;
    }

    @Override
    public void save(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(car);

        session.getTransaction().commit();

        session.close();

    }

    @Override
    public void delete(Car car) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(car);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void persist(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(car);

        session.getTransaction().commit();

        session.close();

    }

    @Override
    public Car get(Long id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);

        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public Car load(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = session.load(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public Car getTypeByName(String name) {

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Car> query = builder.createQuery(Car.class);
            Root<Car> root = query.from(Car.class);
            query.select(root).where(builder.like(root.get("name"), "%Opel%"));

            Query<Car> q = session.createQuery(query);
            Car result = q.getSingleResult();

            return result;
        }

    @Override
    public Car mergeCar(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        car.setName("NewName");
        session.save(car);
        Car newCar = (Car) session.merge(car);
        session.getTransaction().commit();
        session.close();
        return car;
    }


}


