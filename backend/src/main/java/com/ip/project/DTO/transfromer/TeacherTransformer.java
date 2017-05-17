package com.ip.project.DTO.transfromer;

import com.ip.project.DTO.TeacherDTO;
import com.ip.project.model.Teacher;
import org.springframework.stereotype.Component;

/**
 * Created by JACK on 5/13/2017.
 */
@Component
public class TeacherTransformer implements Transformer<Teacher, TeacherDTO> {

    @Override
    public Teacher toModel(TeacherDTO object) {
        Teacher teacher = new Teacher();
        teacher.setId(object.getId());
        teacher.setNume(object.getNume());
        teacher.setPrenume(object.getPrenume());

        return teacher;
    }

    @Override
    public TeacherDTO toDTO(Teacher object) {
        return new TeacherDTO(
                object.getId(),
                object.getNume(),
                object.getPrenume());
    }
}
