package com.testtask.egar.repository;

import com.testtask.egar.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
}
