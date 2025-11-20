package com.prashanth.book;

import com.prashanth.book.role.Role;
import com.prashanth.book.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
public class BookNetworkApiApplication {



	public static void main(String[] args) {

        SpringApplication.run(BookNetworkApiApplication.class, args);

    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {

        return arge -> {
            if(roleRepository.findByName("USER").isEmpty()){
                roleRepository.save(
                        Role.builder()
                                .name("USER")
                                .build()
                );
            }
        };

    }



}
