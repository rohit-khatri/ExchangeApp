package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.ExchangeEntity;
 
@Repository
public interface ExchangeRepository
        extends JpaRepository<ExchangeEntity, Long> {
 
}
