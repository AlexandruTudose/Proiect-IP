package com.ip.project.controller;

import com.ip.project.DTO.MarkDTO;
import com.ip.project.model.Mark;
import com.ip.project.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 5/9/2017.
 */
@RestController
public class MarkController {

    @Autowired
    private MarkService markService;

    //GET ALL MARKS
    @RequestMapping(value = "/marks", method = RequestMethod.GET)
    public Page<MarkDTO> getMarks(Pageable pageable) {
        return markService.getMarks(pageable);
    }

    //GET MARK BY ID
    @RequestMapping(value = "/marks/{id}", method = RequestMethod.GET)
    public MarkDTO getMark(@PathVariable("id") Integer id) {
        return markService.getMark(id);
    }

    //CREATE MARK
    @RequestMapping(value = "/marks", method = RequestMethod.POST)
    public void createMark(@RequestBody MarkDTO markDTO) {
        markService.createMark(markDTO);
    }

    //UPDATE MARK BY ID
    @RequestMapping(value = "/marks/{id}", method = RequestMethod.PUT)
    public void updateMark(@PathVariable("id") Integer id, @RequestBody Mark mark) {
        markService.updateMark(id,mark);
    }

    //DELETE MARK BY ID
    @RequestMapping(value = "/marks/{id}", method = RequestMethod.DELETE)
    public void deleteMark(@PathVariable("id") Integer id) {
        markService.deleteMark(id);
    }
}
