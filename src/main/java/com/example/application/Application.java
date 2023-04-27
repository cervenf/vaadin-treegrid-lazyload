package com.example.application;

import com.example.application.backend.dbo.StudentDbo;
import com.example.application.backend.dbo.TeacherDbo;
import com.example.application.views.RepositoryService;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "treegrid")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RepositoryService repositoryService) {
        return args -> {
            for (int i = 1; i < 1000; i++) {

                var teacher = new TeacherDbo();
                teacher.setName("teacher " + i);

                for (int j = 1; j < 10; j++) {
                    var student = new StudentDbo();
                    student.setName("student " + i + "-" + j);

                    teacher.getStudents().add(student);
                    student.setTeacher(teacher);
                }
                repositoryService.saveTeacher(teacher);
            }
        };
    }

}
