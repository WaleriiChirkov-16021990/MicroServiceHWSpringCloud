package com.chirkov;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import com.chirkov.model.Issue;
import com.chirkov.utils.customAbstract.services.CustomServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class IssueApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueApplication.class, args);
    }
}