package com.example.application.backend.repository;

import com.example.application.backend.dbo.TeacherDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDbo, Long> {

}
