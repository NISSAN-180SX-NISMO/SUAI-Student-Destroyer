package io.swagger.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StudentsDataBaseImpl implements DataBase<Student, String> {
    private ArrayList<Student> students = new ArrayList<>();
    @Override
    public int size() {
        return 0;
    }

    @Override
    public void edit(int index, Student entity) {

    }

    @Override
    public void insert(Student entity) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int find(String value) {
        return 0;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
