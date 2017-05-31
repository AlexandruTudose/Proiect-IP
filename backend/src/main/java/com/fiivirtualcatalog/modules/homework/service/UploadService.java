package com.fiivirtualcatalog.modules.homework.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daniel on 5/16/2017.
 */
public interface UploadService {
    String getFilePath(long memberId, String section);
    boolean uploadFile(String courseName, String newFileName, MultipartFile uploadFile);
    void deleteFile(String filePath, String newFileName);
}
