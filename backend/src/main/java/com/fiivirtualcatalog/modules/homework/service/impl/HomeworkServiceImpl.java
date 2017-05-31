package com.fiivirtualcatalog.modules.homework.service.impl;


import com.fiivirtualcatalog.modules.homework.DTO.HomeworkDTO;
import com.fiivirtualcatalog.modules.homework.DTO.transfromer.HomeworkTransformer;
import com.fiivirtualcatalog.modules.homework.model.Homework;
import com.fiivirtualcatalog.modules.homework.model.Mark;
import com.fiivirtualcatalog.modules.homework.repository.HomeworkRepository;
import com.fiivirtualcatalog.modules.homework.repository.MarkRepository;
import com.fiivirtualcatalog.modules.homework.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JACK on 5/8/2017.
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Autowired
    private HomeworkTransformer homeworkTransformer;

    @Autowired
    private MarkRepository markRepository;

    //TRANSFORM PAGE(HOMEWORK) TO PAGE(HOMEWORK DTO)
    private Page<HomeworkDTO> convertToDTO(Page<Homework> pageable) {
        return pageable.map(homeworkTransformer::toDTO);
    }

    //GET ALL HOMEWORKS
    @Override
    @Transactional(readOnly = true)
    public Page<HomeworkDTO> getHomeworks(Pageable pageable) {

        return convertToDTO(homeworkRepository.findAll(pageable));
    }

    //GET HOMEWORK BY ID
    @Override
    @Transactional(readOnly = true)
    public HomeworkDTO getHomework(Integer id) {

        if (homeworkRepository.findOne(id) != null) {
            return homeworkTransformer.toDTO(homeworkRepository.findOne(id));
        }
        else {
            throw new RuntimeException(" Tema cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //CREATE HOMEWORK
    @Override
    public void createHomework(HomeworkDTO homeworkDTO) {

        homeworkDTO.setFisier(null);
        homeworkDTO.setId_nota(homeworkRepository.getMaxIdMark() + 1);
        homeworkRepository.save(homeworkTransformer.toModel(homeworkDTO));

        Mark mark = new Mark();
        mark.setId(homeworkRepository.getMaxIdMark() + 1);
        markRepository.save(mark);
    }

    //UPDATE HOMEWORK
    @Override
    public void updateHomework(Integer id, Homework homework) {

        if (homeworkRepository.findOne(id) != null) {
            homework.setId(id);
            homeworkRepository.save(homework);
        }
        else {
            throw new RuntimeException(" Tema cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //DELETE HOMEWORK
    @Override
    public void deleteHomework(Integer id) {
        homeworkRepository.delete(id);
    }

    @Override
    public int getLastHomeworkId() {
        return homeworkRepository.getMaxId();
    }

    @Override
    public Page<HomeworkDTO> getHomeworksForStudent(Integer id_stud, Pageable pageable) {
        return convertToDTO(homeworkRepository.getHomeworksByStudent(id_stud, pageable));
    }

    @Override
    public Page<HomeworkDTO> getHomeworksForTeacher(Integer id_prof, Pageable pageable) {
        return convertToDTO(homeworkRepository.getHomeworksByTeacher(id_prof, pageable));
    }

}
