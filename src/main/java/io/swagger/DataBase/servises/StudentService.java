package io.swagger.DataBase.servises;

import io.swagger.DataBase.repos.StudentRepo;
import io.swagger.DataBase.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Transactional
    public Long size() {
        return this.studentRepo.count();
    }

    @Transactional
    public void edit(Student student) {
        if (this.studentRepo.existsById(student.getId())) {
            this.studentRepo.save(student);
        }
    }

    @Transactional
    public void insert(Student entity) {
        this.studentRepo.save(entity);
    }

    @Transactional
    public boolean remove(Long id) {
        if (this.studentRepo.existsById(id))
            this.studentRepo.deleteById(id);
        else return false;
        return true;
    }

    @Transactional
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        this.studentRepo.findAll().forEach(students::add);
        return students;
    }

    @Transactional
    public Optional<Student> find(Long id) {
        return this.studentRepo.findById(id);
    }
}
