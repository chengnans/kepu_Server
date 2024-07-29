package com.kj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.kj.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SchoolOfJournalismAndCommunicationWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolOfJournalismAndCommunicationWebsiteApplication.class, args);
    }

}
