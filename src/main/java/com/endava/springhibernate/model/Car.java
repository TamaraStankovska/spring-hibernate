package com.endava.springhibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String name;

    String type;


    @OneToMany(targetEntity=Wheel.class, fetch=FetchType.EAGER)
    private List<Wheel> wheels;
}
