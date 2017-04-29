package com.fiivirtualcatalog.test.repositories;

import com.fiivirtualcatalog.test.models.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexandru on 4/27/2017.
 */
public interface TestModelRepository extends JpaRepository<TestModel, Long> {
    TestModel save(TestModel entity);
}
