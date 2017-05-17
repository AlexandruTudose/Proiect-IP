package com.ip.project.service;

import com.ip.project.DTO.TeacherDTO;
import com.ip.project.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 5/9/2017.
 */
public interface TeacherService {

    Page<TeacherDTO> getTeachers(Pageable pageable);
    TeacherDTO getTeacher(Integer id);

    void createTeacher(TeacherDTO teacherDTO);
    void updateTeacher(Integer id, Teacher teacher);
    void deleteTeacher(Integer id);
}
