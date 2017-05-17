package com.ip.project.service.impl;

import com.ip.project.DTO.HomeworkDTO;
import com.ip.project.DTO.transfromer.HomeworkTransformer;
import com.ip.project.model.Homework;
import com.ip.project.model.Mark;
import com.ip.project.repository.HomeworkRepository;
import com.ip.project.repository.MarkRepository;
import com.ip.project.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by JACK on 5/8/2017.
 */
@Service
public class HomeworkServiceImpl implements HomeworkService{

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private HomeworkTransformer homeworkTransformer;

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
        System.out.println(homeworkDTO.getTip_tema());
        homeworkDTO.setId_nota(homeworkRepository.getMaxIdMark() + 1);
        homeworkRepository.save(homeworkTransformer.toModel(homeworkDTO));
//        Mark mark = new Mark();
//        mark.setId(homeworkRepository.getMaxIdMark() + 1);
//        markRepository.save(mark);
    }

    @Override
    public void addHomework(HomeworkDTO homeworkDTO) {
        System.out.println(homeworkTransformer.toModel(homeworkDTO));
        homeworkRepository.save(homeworkTransformer.toModel(homeworkDTO));
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
    public int getLastHomeworkId(int id) {
        return homeworkRepository.getMaxId(id);
    }



//    @Override
//    public Page<HomeworkDTO> getHomeworksByStudent(Integer id_stud, Pageable pageable) {
//
//        if (homeworkRepository.findByIdStudent(id_stud, pageable) != null) {
//            return convertToDTO(homeworkRepository.findByIdStudent(id_stud, pageable));
//        }
//        else {
//            throw new RuntimeException(" Tema cu id-ul "+ id +" nu exista in baza de date ");
//        }
//        //return convertToDTO(homeworkRepository.findAll(pageable));
//    }


}
