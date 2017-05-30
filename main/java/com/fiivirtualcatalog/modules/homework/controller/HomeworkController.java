package com.fiivirtualcatalog.modules.homework.controller;

import com.fiivirtualcatalog.modules.homework.DTO.HomeworkDTO;
import com.fiivirtualcatalog.modules.homework.facade.HomeworkUpload;
import com.fiivirtualcatalog.modules.homework.model.Homework;
import com.fiivirtualcatalog.modules.homework.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JACK on 5/8/2017.
 */
@RestController
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private HomeworkUpload homeworkUpload;

    //GET ALL HOMEWORKS
    @RequestMapping(value = "/homeworks", method = RequestMethod.GET)
    public Page<HomeworkDTO> getHomeworks(Pageable pageable) {
        return homeworkService.getHomeworks(pageable);
    }

    //GET HOMEWORK BY ID
    @RequestMapping(value = "/homeworks/{id}", method = RequestMethod.GET)
    public HomeworkDTO getHomework(@PathVariable("id") Integer id) {
        return homeworkService.getHomework(id);
    }

    //CREATE HOMEWORK --PETRICA
    @RequestMapping(value = "/homeworks", method = RequestMethod.POST)
    public void createHomework(@RequestBody HomeworkDTO homeworkDTO) {
        homeworkService.createHomework(homeworkDTO);
    }

    //UPDATE HOMEWORK BY ID
    @RequestMapping(value = "/homeworks/{id}", method = RequestMethod.PUT)
    public void updateHomework(@PathVariable("id") Integer id, @RequestBody Homework homework) {
        homeworkService.updateHomework(id,homework);
    }

    //DELETE HOMEWORK BY ID
    @RequestMapping(value = "/homeworks/{id}", method = RequestMethod.DELETE)
    public void deleteHomework(@PathVariable("id") Integer id) {
        homeworkService.deleteHomework(id);
    }


    @RequestMapping(value = "/homeworks/{id_stud}/upload", method=RequestMethod.POST)
    public boolean uploadHomeworkZip(@PathVariable("id_stud") int id_stud, @RequestParam("files") MultipartFile uploadingFile) {
        return homeworkUpload.uploadHomework(id_stud, uploadingFile);
    }

    @RequestMapping(value = "/homeworks/student/{id}", method = RequestMethod.GET)
    public Page<HomeworkDTO> getHomeworksForStudent(@PathVariable("id") Integer id_stud, Pageable pageable) {
        return homeworkService.getHomeworksForStudent(id_stud,pageable);
    }

    @RequestMapping(value = "/homeworks/teacher/{id}", method = RequestMethod.GET)
    public Page<HomeworkDTO> getHomeworksForTeacher(@PathVariable("id") Integer id_prof, Pageable pageable) {
        return homeworkService.getHomeworksForTeacher(id_prof,pageable);
    }


}
