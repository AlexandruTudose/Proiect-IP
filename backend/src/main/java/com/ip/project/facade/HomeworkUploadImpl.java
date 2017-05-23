package com.ip.project.facade;

import com.ip.project.DTO.HomeworkDTO;
import com.ip.project.DTO.StudentDTO;
import com.ip.project.DTO.transfromer.HomeworkTransformer;
import com.ip.project.service.HomeworkService;
import com.ip.project.service.StudentService;
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
    private StudentService studentService;

    @Autowired
    private HomeworkTransformer homeworkTransformer;

    @Override
    public boolean uploadHomework(int id_stud, MultipartFile uploadedFile) {
//
//        int homeworkNumber = homeworkService.getLastHomeworkId();
//
//        for(MultipartFile uploadedFile : uploadingFiles) {
//            String newFileName = id_stud + "_" + homeworkNumber + "." + FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
//            uploadService.uploadFile(uploadService.getFilePath(id_stud, "homeworks"), newFileName, uploadedFile);
//
//            System.out.println(newFileName);
//            HomeworkDTO homeworkDTO = new HomeworkDTO();
//            homeworkDTO.setFisier(newFileName);
//
//            homeworkService.updateHomework(homeworkNumber,homeworkTransformer.toModel(homeworkDTO));
//
//            homeworkNumber++;
//        }
//
//        return true;
        int homeworkNumber = homeworkService.getLastHomeworkId();
        HomeworkDTO homeworkDTO = homeworkService.getHomework(homeworkNumber);
        StudentDTO studentDTO = studentService.getStudent(id_stud);

        if (homeworkDTO != null){
            String newFileName = studentDTO.getNume()+ "_" + studentDTO.getPrenume() + "_tema_"+ homeworkNumber + ".zip";

            homeworkDTO.setFisier(newFileName);
            homeworkService.updateHomework(homeworkNumber, homeworkTransformer.toModel(homeworkDTO));

            uploadService.uploadFile(newFileName, uploadedFile);
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
