package com.example.application.views;

import com.example.application.backend.dbo.TeacherDbo;
import com.example.application.backend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
public class RepositoryService {

    private final TeacherRepository teacherRepository;

    public void saveTeacher(TeacherDbo teacherDbo) {
        teacherRepository.save(teacherDbo);
    }

}
