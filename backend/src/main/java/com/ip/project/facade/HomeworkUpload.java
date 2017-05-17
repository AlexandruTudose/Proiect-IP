package com.ip.project.facade;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daniel on 5/16/2017.
 */
public interface HomeworkUpload {

    //boolean uploadProductImg(int id, MultipartFile[] uploadingFiles);

    boolean uploadHomework(int id, MultipartFile[] uploadingFiles);
    //void deleteProductImg(int id);
}
