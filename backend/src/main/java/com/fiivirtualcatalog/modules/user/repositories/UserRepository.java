package com.fiivirtualcatalog.modules.user.repositories;

import com.fiivirtualcatalog.modules.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findById(Long id);

}
