package com.ip.project.service.impl;

import com.ip.project.DTO.MarkDTO;
import com.ip.project.DTO.transfromer.MarkTransformer;
import com.ip.project.model.Mark;
import com.ip.project.repository.MarkRepository;
import com.ip.project.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JACK on 5/9/2017.
 */
@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private MarkTransformer markTransformer;

    //TRANSFORM PAGE(MARK) TO PAGE(MARK DTO)
    private Page<MarkDTO> convertToDTO(Page<Mark> pageable) {

        return pageable.map(markTransformer::toDTO);
    }

    //GET ALL MARKS
    @Override
    @Transactional(readOnly = true)
    public Page<MarkDTO> getMarks(Pageable pageable) {

        return convertToDTO(markRepository.findAll(pageable));
    }

    //GET MARK BY ID
    @Override
    @Transactional(readOnly = true)
    public MarkDTO getMark(Integer id) {

        if (markRepository.findOne(id) != null) {
            return markTransformer.toDTO(markRepository.findOne(id));
        }
        else {
            throw new RuntimeException(" Nota cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //CREATE MARK
    @Override
    public void createMark(MarkDTO markDTO) {

        markRepository.save(markTransformer.toModel(markDTO));
    }

    //UPDATE MARK BY ID
    @Override
    public void updateMark(Integer id, Mark mark) {

        if (markRepository.findOne(id) != null) {
            mark.setId(id);
            markRepository.save(mark);
        }
        else {
            throw new RuntimeException(" Nota cu id-ul "+ id +" nu exista in baza de date ");
        }
    }

    //DELETE MARK BY ID
    @Override
    public void deleteMark(Integer id) {

        markRepository.delete(id);
    }
}
