package com.ip.project.service.impl;

import com.ip.project.DTO.StudentDTO;
import com.ip.project.DTO.transfromer.StudentTransformer;
import com.ip.project.model.Student;
import com.ip.project.repository.StudentRepository;
import com.ip.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JACK on 5/7/2017.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentTransformer studentTransformer;

    //TRANSFORM PAGE(COURSE) TO PAGE(COURSE DTO)
    private Page<StudentDTO> convertToDTO(Page<Student> pageable) {

        return pageable.map(studentTransformer::toDTO);
    }

    //GET ALL STUDENTS
    @Override
    @Transactional(readOnly = true)
    public Page<StudentDTO> getStudents(Pageable pageable) {

        return convertToDTO(studentRepository.findAll(pageable));
    }

    //GET ONE STUDENT BY ID
    @Override
    @Transactional(readOnly = true)
    public StudentDTO getStudent(Integer nr_matricol) {

        if (studentRepository.findOne(nr_matricol) != null) {
            return studentTransformer.toDTO(studentRepository.findOne(nr_matricol));
        }
        else {
            throw new RuntimeException(" Studentul cu numarul matricol "+ nr_matricol +" nu exista in baza de date ");
        }
    }

    //CREATE STUDENT
    @Override
    public void createStudent(StudentDTO studentDTO) {

        studentRepository.save(studentTransformer.toModel(studentDTO));
    }

    //UPDATE STUDENT BY ID
    @Override
    public void updateStudent(Integer nr_matricol, Student student) {

        if (studentRepository.findOne(nr_matricol) != null) {
            student.setNr_matricol(nr_matricol);
            studentRepository.save(student);
        }
        else {
            throw new RuntimeException(" Studentul cu numarul matricol "+ nr_matricol +" nu exista in baza de date ");
        }
    }

    //DELETE STUDENT BY ID
    @Override
    public void deleteStudent(Integer nr_matricol) {
        studentRepository.delete(nr_matricol);
    }
}
