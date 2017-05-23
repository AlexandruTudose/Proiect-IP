package com.ip.project.repository;

import com.ip.project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by JACK on 5/2/2017.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
