package com.ip.project.service.impl;

import com.ip.project.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Daniel on 5/16/2017.
 */
@Service
public class UploadServiceImpl implements UploadService{

    @Value("${upload.folder}")
    private String clientsUploadFolder;

    @Value("${upload.folderSep}")
    private String clientsUploadFolderSep;

    @Override
    public boolean uploadFile(String newFileName, MultipartFile uploadFile) {
        return transferFile(clientsUploadFolder + clientsUploadFolderSep + newFileName, uploadFile);
    }

    @Override
    public void deleteFile(String filePath, String newFileName) {
        File file = new File(filePath + clientsUploadFolderSep + newFileName);
        if (file.exists()){
            file.delete();
        }
    }

    @Override
    public String getFilePath(long memberId, String section){
        String pathDirUpload  = clientsUploadFolder + memberId + clientsUploadFolderSep;

        if (!section.isEmpty()){
            pathDirUpload += clientsUploadFolderSep + section;
        }

        File dirUpload = new File(pathDirUpload);
        if(!dirUpload.exists()){
            dirUpload.mkdir();
        }

        return pathDirUpload;
    }

    public boolean transferFile(String fileName, MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =  new BufferedOutputStream(new FileOutputStream(new File(fileName)));
            stream.write(bytes);
            stream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
