package com.fiivirtualcatalog.modules.homework.facade;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daniel on 5/16/2017.
 */
public interface HomeworkUpload {

    boolean uploadHomework(int id_stud, MultipartFile uploadingFile);
    //void deleteProductImg(int id);
}
