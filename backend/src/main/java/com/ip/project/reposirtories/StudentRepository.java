package com.ip.project.reposirtories;

import com.ip.project.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JACK on 5/2/2017.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
