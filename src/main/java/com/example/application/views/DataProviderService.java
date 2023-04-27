package com.example.application.views;

import com.example.application.backend.dbo.TeacherDbo;
import com.example.application.backend.dto.TreeNode;
import com.example.application.backend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


@RequiredArgsConstructor
@Service
@Transactional
public class DataProviderService {

    private final TeacherRepository teacherRepository;

    public Stream<TreeNode> getAllTeachers(PageRequest pageRequest) {
        return teacherRepository.findAll(pageRequest)
                .stream()
                .map(t -> new TreeNode(t.getId(), t.getName(), "teacher"));
    }

    public List<TreeNode> getStudentsByTeacher(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .map(TeacherDbo::getStudents)
                .stream().flatMap(Collection::stream)
                .map(s -> new TreeNode(s.getId(), s.getName(), "student"))
                .toList();
    }

    public int getTeacherCount() {
        return (int) teacherRepository.count();
    }

}
