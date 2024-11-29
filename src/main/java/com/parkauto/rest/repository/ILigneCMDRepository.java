package com.parkauto.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkauto.rest.entity.LigneCMD;

import jakarta.persistence.Entity;

@Repository
public interface ILigneCMDRepository extends JpaRepository<LigneCMD, Long> {

}
