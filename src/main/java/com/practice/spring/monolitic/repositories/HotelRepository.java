package com.practice.spring.monolitic.repositories;

import com.practice.spring.monolitic.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
