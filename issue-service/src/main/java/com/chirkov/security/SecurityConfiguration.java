//package com.chirkov.security;
//
//import com.chirkov.model.Issue;
//import com.chirkov.utils.customAbstract.services.CustomServices;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .build();
//
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(CustomServices<Issue, Long, JpaRepository<Issue, Long>> customServices) {
//        return args -> {
//            Issue issue = new Issue("title", "description", 1L, 1L);
//            customServices.create(issue);
//        };
//    } // CommandLineRunner
//}
