package com.fiivirtualcatalog.modules.homework.repository;


import com.fiivirtualcatalog.modules.homework.model.Homework;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JACK on 5/8/2017.
 */
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    @Query("select max(m.id) from Homework m")
    int getMaxId();

    @Query("select count(m) from Homework m")
    int getMaxIdMark();

    @Query("select m from Homework m where m.id_student = ?1")
    Page<Homework> getHomeworksByStudent(Integer id_student, Pageable pageable);

    @Query("select h from com.fiivirtualcatalog.modules.homework.model.Homework h, com.fiivirtualcatalog.modules.homework.model.Mark m  where h.id_nota = m.id and m.id_profesor = ?1")
    Page<Homework> getHomeworksByTeacher(Integer id_profesor, Pageable pageable);
}
