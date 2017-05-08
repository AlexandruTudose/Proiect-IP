package com.fiivirtualcatalog.login.repositories;

import com.fiivirtualcatalog.login.models.ConfirmEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmEmailRepository extends JpaRepository<ConfirmEmail,String> {

    ConfirmEmail findByEmail(String email);
    void deleteByEmail(String email);
}
