package com.OrderSystem.Order.config;

import com.OrderSystem.Order.entities.Order;
import com.OrderSystem.Order.entities.User;
import com.OrderSystem.Order.enums.OrderStatus;
import com.OrderSystem.Order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

import com.OrderSystem.Order.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
	private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Isaque Santos Pinto", "isaquesantos.1998@gmail.com", "71987308769", "86992134");
        User user2 = new User(null, "Eliseu Santos Pinto", "elispdam.1999@gmail.com", "7196102550", "33556678");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),  OrderStatus.SHIPPED, user1);

        this.userRepository.saveAll(Arrays.asList(user1, user2));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
