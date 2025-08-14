package com.example.Hack.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hack.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {
    Sample findByEmailAndPassword(String email, String password);
}