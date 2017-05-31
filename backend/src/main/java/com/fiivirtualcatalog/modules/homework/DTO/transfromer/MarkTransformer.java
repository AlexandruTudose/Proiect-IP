package com.fiivirtualcatalog.modules.homework.DTO.transfromer;


import com.fiivirtualcatalog.modules.homework.DTO.MarkDTO;
import com.fiivirtualcatalog.modules.homework.model.Mark;
import org.springframework.stereotype.Component;

/**
 * Created by JACK on 5/13/2017.
 */
@Component
public class MarkTransformer implements Transformer<Mark, MarkDTO> {

    @Override
    public Mark toModel(MarkDTO object) {
        Mark mark = new Mark();
        mark.setId(object.getId());
        mark.setId_profesor(object.getId_profesor());
        mark.setData_notare(object.getData_notare());
        mark.setValoare(object.getValoare());

        return mark;
    }

    @Override
    public MarkDTO toDTO(Mark object) {
        return new MarkDTO(
                object.getId(),
                object.getId_profesor(),
                object.getData_notare(),
                object.getValoare());
    }
}
