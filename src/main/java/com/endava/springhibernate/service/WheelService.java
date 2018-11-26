package com.endava.springhibernate.service;

import com.endava.springhibernate.model.Wheel;
import org.springframework.stereotype.Service;

import java.util.List;
public interface WheelService {
    List<Wheel> findAll();
    Wheel findById(Long id);
    void save(Wheel wheel);
    void delete(Wheel wheel);

}
