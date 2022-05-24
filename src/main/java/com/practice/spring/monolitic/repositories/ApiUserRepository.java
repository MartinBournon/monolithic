package com.practice.spring.monolitic.repositories;

import com.practice.spring.monolitic.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser,Long> {
}
