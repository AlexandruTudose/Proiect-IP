package com.ip.project.controller;

import com.ip.project.DTO.HomeworkDTO;
import com.ip.project.facade.HomeworkUpload;
import com.ip.project.model.Homework;
import com.ip.project.service.HomeworkService;
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

    //CREATE HOMEWORK
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

    @RequestMapping(value = "/homeworks/upload", method = RequestMethod.POST)
    public void addHomework(@RequestBody HomeworkDTO homeworkDTO) {
        homeworkService.addHomework(homeworkDTO);
    }

    @RequestMapping(value = "/homeworks/{id}/upload", method=RequestMethod.POST)
    public boolean uploadCatalogProductImg(@PathVariable("id") int id, @RequestParam("files") MultipartFile[] uploadingFiles) {
        return homeworkUpload.uploadHomework(id, uploadingFiles);
    }
}
