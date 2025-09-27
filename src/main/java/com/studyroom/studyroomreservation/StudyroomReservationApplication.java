package com.studyroom.studyroomreservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class StudyroomReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyroomReservationApplication.class, args);
    }//
//DB 연결 확인용 테스트
//    @Bean
//    CommandLineRunner testDb(DataSource dataSource) {
//        return args -> {
//            try (Connection conn = dataSource.getConnection()) {
//                System.out.println("DB 연결 성공: " + conn.getMetaData().getURL());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        };
//    }
}
