package com.exercise.springhibernate.dao;

import com.exercise.springhibernate.model.Wheel;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class WheelDaoImpl implements WheelDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Wheel> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();

        CriteriaQuery<Wheel> criteriaQuery=builder.createQuery(Wheel.class);


        criteriaQuery.from(Wheel.class);


        List<Wheel> wheels=session.createQuery(criteriaQuery).getResultList();
        session.close();

        return wheels;
    }

    @Override
    public void save(Wheel wheel) {
        Session session=sessionFactory.openSession();

        session.beginTransaction();

        session.saveOrUpdate(wheel);

        session.getTransaction().commit();

        session.close();

    }

    @Override
    public void delete(Wheel wheel) {
        Session session=sessionFactory.openSession();

        session.beginTransaction();

        session.delete(wheel);

        session.getTransaction().commit();

        session.close();


    }

    @Override
    public Wheel findById(Long id) {
        Session session=sessionFactory.openSession();
        Wheel wheel=session.get(Wheel.class,id);
        Hibernate.initialize(wheel.getId());
        session.close();
        return wheel;
    }

    @Override
    public void persist(Wheel wheel) {

        Session session=sessionFactory.openSession();

        session.beginTransaction();

        session.persist(wheel);

        session.getTransaction().commit();

        session.close();

    }

    @Override
    public Wheel get(Long id) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Wheel wheel= session.get(Wheel.class, id);

        session.getTransaction().commit();
        session.close();
        return wheel;
    }

    @Override
    public Wheel load(Long id) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Wheel wheel= session.load(Wheel.class, id);

        session.getTransaction().commit();
        session.close();
        return wheel;    }
}
