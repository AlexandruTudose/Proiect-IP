package com.ip.project.service;

import com.ip.project.DTO.HomeworkDTO;
import com.ip.project.model.Homework;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 5/8/2017.
 */
public interface HomeworkService {

    Page<HomeworkDTO> getHomeworks(Pageable pageable);
    HomeworkDTO getHomework(Integer id);

    void createHomework(HomeworkDTO homeworkDTO);
    void updateHomework(Integer id, Homework homework);
    void deleteHomework(Integer id);

    int getLastHomeworkId();
    Page<HomeworkDTO> getHomeworksForStudent(Integer id_stud, Pageable pageable);
    Page<HomeworkDTO> getHomeworksForTeacher(Integer id_prof, Pageable pageable);

}
