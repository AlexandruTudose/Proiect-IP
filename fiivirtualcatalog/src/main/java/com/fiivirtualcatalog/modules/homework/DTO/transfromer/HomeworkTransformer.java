package com.fiivirtualcatalog.modules.homework.DTO.transfromer;


import com.fiivirtualcatalog.modules.homework.DTO.HomeworkDTO;
import com.fiivirtualcatalog.modules.homework.model.Homework;
import org.springframework.stereotype.Component;

/**
 * Created by JACK on 5/13/2017.
 */
@Component
public class HomeworkTransformer implements Transformer<Homework, HomeworkDTO> {

    @Override
    public Homework toModel(HomeworkDTO object) {
        Homework homework = new Homework();
        homework.setId(object.getId());
        homework.setId_curs(object.getId_curs());
        homework.setId_student(object.getId_student());
        homework.setId_nota(object.getId_nota());
        homework.setTip_tema(object.getTip_tema());
        homework.setFisier(object.getFisier());
        homework.setData_predare(object.getData_predare());

        return homework;
    }

    @Override
    public HomeworkDTO toDTO(Homework object) {
        return new HomeworkDTO(
                object.getId(),
                object.getId_curs(),
                object.getId_student(),
                object.getId_nota(),
                object.getTip_tema(),
                object.getFisier(),
                object.getData_predare());
    }
}
