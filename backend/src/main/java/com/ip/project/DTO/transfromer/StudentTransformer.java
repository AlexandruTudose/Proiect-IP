package com.ip.project.DTO.transfromer;

import com.ip.project.DTO.StudentDTO;
import com.ip.project.model.Student;
import org.springframework.stereotype.Component;

/**
 * Created by JACK on 5/13/2017.
 */
@Component
public class StudentTransformer implements Transformer<Student, StudentDTO> {

    @Override
    public Student toModel(StudentDTO object) {
        Student student = new Student();
        student.setNr_matricol(object.getNr_matricol());
        student.setNume(object.getNume());
        student.setPrenume(object.getPrenume());
        student.setGrupa(object.getGrupa());
        student.setAn(object.getAn());

        return student;
    }

    @Override
    public StudentDTO toDTO(Student object) {
        return new StudentDTO(
                object.getNr_matricol(),
                object.getNume(),
                object.getPrenume(),
                object.getGrupa(),
                object.getAn());
    }
}
