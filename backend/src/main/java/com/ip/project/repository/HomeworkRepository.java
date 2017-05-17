package com.ip.project.repository;

import com.ip.project.model.Homework;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by JACK on 5/8/2017.
 */
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    @Query("select count(m.id) from Homework m where m.id = ?1")
    int getMaxId(int id);

    @Query("select count(m) from Homework m")
    int getMaxIdMark();

    @Query("select count(m) from Homework m")
    int getMaxIdHomework();
}
