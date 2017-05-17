package com.ip.project.service.impl;

import com.ip.project.DTO.TeacherDTO;
import com.ip.project.DTO.transfromer.TeacherTransformer;
import com.ip.project.model.Teacher;
import com.ip.project.repository.TeacherRepository;
import com.ip.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JACK on 5/9/2017.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherTransformer teacherTransformer;

    //TRANSFORM PAGE(COURSE) TO PAGE(COURSE DTO)
    private Page<TeacherDTO> convertToDTO(Page<Teacher> pageable) {

        return pageable.map(teacherTransformer::toDTO);
    }

    //GET ALL TEACHERS
    @Override
    @Transactional(readOnly = true)
    public Page<TeacherDTO> getTeachers(Pageable pageable) {

        return convertToDTO(teacherRepository.findAll(pageable));
    }

    //GET TEACHER BY ID
    @Override
    @Transactional(readOnly = true)
    public TeacherDTO getTeacher(Integer id) {

        if (teacherRepository.findOne(id) != null) {
            return teacherTransformer.toDTO(teacherRepository.findOne(id));
        }
        else {
            throw new RuntimeException(" Profesorul cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //CREATE TEACHER
    @Override
    public void createTeacher(TeacherDTO teacherDTO) {

        teacherRepository.save(teacherTransformer.toModel(teacherDTO));
    }

    //UPDATE TEACHER BY ID
    @Override
    public void updateTeacher(Integer id, Teacher teacher) {

        if (teacherRepository.findOne(id) != null) {
            teacher.setId(id);
            teacherRepository.save(teacher);
        }
        else {
            throw new RuntimeException(" Profesorul cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //DELETE TEACHER BY ID
    @Override
    public void deleteTeacher(Integer id) {

        teacherRepository.delete(id);
    }
}
