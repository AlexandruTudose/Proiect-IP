package com.ip.project.facade;

import com.ip.project.DTO.HomeworkDTO;
import com.ip.project.repository.HomeworkRepository;
import com.ip.project.service.HomeworkService;
import com.ip.project.service.UploadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daniel on 5/16/2017.
 */
@Component
public class HomeworkUploadImpl implements HomeworkUpload{

    @Autowired
    private UploadService uploadService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public boolean uploadHomework(int id_tema, MultipartFile[] uploadingFiles) {

        int homeworkNumber = homeworkRepository.getMaxIdHomework();
        for(MultipartFile uploadedFile : uploadingFiles) {
            String newFileName = "Tema_" + id_tema + "_" + homeworkNumber + "." + FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
            uploadService.uploadFile(uploadService.getFilePath(id_tema, "homeworks"), newFileName, uploadedFile);

            HomeworkDTO homeworkDTO = new HomeworkDTO();
            homeworkDTO.setId(homeworkNumber);
            homeworkDTO.setTip_tema("tema");
            homeworkDTO.setId_nota(homeworkRepository.getMaxIdMark() +1);
            homeworkDTO.setId_student(1);
            homeworkDTO.setId_curs(2);
            homeworkDTO.setData_predare(java.sql.Date.valueOf("2017-01-03"));
            homeworkDTO.setFisier(newFileName);

            homeworkService.addHomework(homeworkDTO);

            homeworkNumber++;
        }

        return true;
    }

//    @Override
//    public void deleteProductImg(long id, long memberId) {
//        MemberProductImgVO memberProductImgVO = memberCatalogService.getCatalogProductImg(id);
//
//        uploadService.deleteFile(uploadService.getFilePath(memberProductImgVO.getMemberProductId(), "products"), memberProductImgVO.getName());
//
//        memberCatalogService.deleteImgFromMemberProduct(id);
//    }
}
