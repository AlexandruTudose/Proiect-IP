package com.fiivirtualcatalog.modules.homework.service;


import com.fiivirtualcatalog.modules.homework.DTO.MarkDTO;
import com.fiivirtualcatalog.modules.homework.model.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 5/9/2017.
 */
public interface MarkService {

    Page<MarkDTO> getMarks(Pageable pageable);
    MarkDTO getMark(Integer id);

    void createMark(MarkDTO markDTO);
    void updateMark(Integer id, Mark mark);
    void deleteMark(Integer id);
}
