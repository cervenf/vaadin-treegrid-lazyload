package com.example.application.backend.repository;

import com.example.application.backend.dbo.StudentDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDbo, Long> {

}
