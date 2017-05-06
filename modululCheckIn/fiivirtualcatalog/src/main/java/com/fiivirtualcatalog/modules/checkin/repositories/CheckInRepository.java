package com.fiivirtualcatalog.modules.checkin.repositories;

import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}
