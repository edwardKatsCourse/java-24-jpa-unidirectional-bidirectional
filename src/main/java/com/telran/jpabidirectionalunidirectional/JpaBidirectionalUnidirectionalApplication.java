package com.telran.jpabidirectionalunidirectional;

import com.telran.jpabidirectionalunidirectional.model.Developer;
import com.telran.jpabidirectionalunidirectional.model.Student;
import com.telran.jpabidirectionalunidirectional.model.Teacher;
import com.telran.jpabidirectionalunidirectional.model.TeamLeader;
import com.telran.jpabidirectionalunidirectional.repository.DeveloperRepository;
import com.telran.jpabidirectionalunidirectional.repository.StudentRepository;
import com.telran.jpabidirectionalunidirectional.repository.TeacherRepository;
import com.telran.jpabidirectionalunidirectional.repository.TeamLeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JpaBidirectionalUnidirectionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaBidirectionalUnidirectionalApplication.class, args);
    }
}

@Component
class SpringMain implements CommandLineRunner {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private TeamLeaderRepository teamLeaderRepository;

    @Override
    public void run(String... args) throws Exception {

        TeamLeader teamLeader = TeamLeader.builder()
                .name("Yosi")
                .build();

        teamLeaderRepository.save(teamLeader);

        Developer sharon = Developer.builder()
                .name("Sharon")
                .teamLeader(teamLeader)
                .build();

        Developer pavel = Developer.builder()
                .name("Pavel")
                .teamLeader(teamLeader)
                .build();

        developerRepository.save(sharon);
        developerRepository.save(pavel);

        System.out.println(teamLeader);

        TeamLeader separateTeamLeader = developerRepository.getTeamLeader("Yosi");
        System.out.printf("Our team leader is: %s", separateTeamLeader);


    }

    private void bidirectional() {
        Teacher teacher = Teacher.builder()
                .name("Pavel")
                .subject("Mathematics")
                .build();
        teacherRepository.save(teacher);


        Student s1 = Student.builder()
                .name("Anton")
                .teacher(teacher)
                .build();

        Student s2 = Student.builder()
                .name("Sarah")
                .teacher(teacher)
                .build();

        Student s3 = Student.builder().name("Mara").teacher(teacher).build();

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);

        System.out.println(teacher);
    }
}