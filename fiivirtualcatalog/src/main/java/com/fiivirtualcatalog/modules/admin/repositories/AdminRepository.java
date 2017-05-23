package com.fiivirtualcatalog.modules.admin.repositories;

import com.fiivirtualcatalog.modules.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, Long> {
}
