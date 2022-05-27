package com.practice.spring.monolithic.repositories;

import com.practice.spring.monolithic.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser,Long> {
}
