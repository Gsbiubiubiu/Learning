package com.gs.designmodel.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-15 19:26
 **/
public class Class implements Iterable<Student>{

    private final List<Student> students = new ArrayList<>();

    public Class() {
        students.add(new Student("学生A", 12));
        students.add(new Student("学生B", 20));
        students.add(new Student("学生C", 30));
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Student> {

        int index = 0;

        @Override
        public boolean hasNext() {
            if(index < students.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Student next() {
            Student student = students.get(index);
            index++;
            return student;
        }
    }
}