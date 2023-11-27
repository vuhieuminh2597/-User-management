package com.exercise.studentmanagement.config;

import com.exercise.studentmanagement.entity.Student;
import com.exercise.studentmanagement.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDataBase {
    private static Logger logger = LoggerFactory.getLogger(ConfigDataBase.class);
    @Bean
    public CommandLineRunner initDataBase(StudentRepository studentRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Student student1 = new Student("Vũ Minh Hiếu","25/09/1997","Bình Dương"
                        ,"vuhieuminh2597@gmail.com","0966916008");
                logger.info("Insert data: " , studentRepository.save(student1).toString());
            }
        };
    }
}
