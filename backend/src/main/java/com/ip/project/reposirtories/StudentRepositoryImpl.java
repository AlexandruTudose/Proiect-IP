package com.ip.project.reposirtories;

import com.ip.project.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 5/2/2017.
 */
public class StudentRepositoryImpl {

    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student getStudent(Integer nr_matricol) {
        return studentRepository.findOne(nr_matricol);
    }

    public void updateStudent(Integer nr_matricol, Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Integer nr_matricol) {
        studentRepository.delete(nr_matricol);
    }
}
