package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profile1;


@Repository
public interface ProfileRepository extends JpaRepository<Profile1, Long> {
}