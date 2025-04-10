package com.gs.designmodel.iterator;

import lombok.Data;


/**
 * @author: Gaos
 * @Date: 2023-08-15 19:28
 **/
@Data
public class Student {

    private String name;

    private Integer year;

    public Student getOne() {
        return this;
    }

    public Student(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public Student() {
    }
}