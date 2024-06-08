package com.OrderSystem.Order.config;

import com.OrderSystem.Order.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

import com.OrderSystem.Order.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
	private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Isaque Santos Pinto", "isaquesantos.1998@gmail.com", "71987308769", "86992134");
        User user2 = new User(null, "Eliseu Santos Pinto", "elispdam.1999@gmail.com", "7196102550", "33556678");

        this.userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
