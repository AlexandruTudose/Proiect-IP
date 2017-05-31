package com.fiivirtualcatalog.modules.homework.facade;


import com.fiivirtualcatalog.modules.homework.DTO.CourseDTO;
import com.fiivirtualcatalog.modules.homework.DTO.HomeworkDTO;
import com.fiivirtualcatalog.modules.homework.DTO.transfromer.HomeworkTransformer;
import com.fiivirtualcatalog.modules.homework.service.CourseService;
import com.fiivirtualcatalog.modules.homework.service.HomeworkService;
import com.fiivirtualcatalog.modules.homework.service.UploadService;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
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
    private UserService studentService;

    @Autowired
    private HomeworkTransformer homeworkTransformer;

    @Autowired
    private CourseService courseService;

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
        CourseDTO courseDTO = courseService.getCourse(homeworkDTO.getId_curs());
        User studentDTO = studentService.findById((long) id_stud);

        if (homeworkDTO != null){
            String newFileName = studentDTO.getFirstName()+ "_" + studentDTO.getLastName() + "_tema_"+ homeworkNumber + "." + FilenameUtils.getExtension(uploadedFile.getOriginalFilename());

            homeworkDTO.setFisier(newFileName);
            homeworkService.updateHomework(homeworkNumber, homeworkTransformer.toModel(homeworkDTO));

            uploadService.uploadFile(courseDTO.getDenumire(),newFileName, uploadedFile);
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
