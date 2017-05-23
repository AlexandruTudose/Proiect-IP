package com.fiivirtualcatalog.modules.user.repositories;

import com.fiivirtualcatalog.modules.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
