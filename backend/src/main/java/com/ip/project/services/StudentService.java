package com.ip.project.services;

import com.ip.project.entities.Student;
import com.ip.project.reposirtories.StudentRepository;
import com.ip.project.reposirtories.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 5/2/2017.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepositoryImpl studentRepositoryImpl;

    public void createStudent(Student student) {
        studentRepositoryImpl.createStudent(student);
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepositoryImpl.getStudents(pageable);
    }

    public Student getStudent(Integer nr_matricol) {
        return studentRepositoryImpl.getStudent(nr_matricol);
    }

    public void updateStudent(Integer nr_matricol, Student student) {
        studentRepositoryImpl.updateStudent(nr_matricol,student);
    }

    public void deleteStudent(Integer nr_matricol) {
        studentRepositoryImpl.deleteStudent(nr_matricol);
    }
}
