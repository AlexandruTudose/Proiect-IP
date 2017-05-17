package com.ip.project.service;

import com.ip.project.DTO.StudentDTO;
import com.ip.project.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 5/2/2017.
 */

public interface StudentService {

    Page<StudentDTO> getStudents(Pageable pageable);
    StudentDTO getStudent(Integer nr_matricol);

    void createStudent(StudentDTO studentDTO);
    void updateStudent(Integer nr_matricol, Student student);
    void deleteStudent(Integer nr_matricol);
}
