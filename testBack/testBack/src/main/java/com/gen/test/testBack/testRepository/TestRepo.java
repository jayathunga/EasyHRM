package com.gen.test.testBack.testRepository;

import com.gen.test.testBack.testDomain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TestRepo extends JpaRepository<Test,String> {
}
