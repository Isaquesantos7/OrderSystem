package com.OrderSystem.Order.DTOS;

import com.OrderSystem.Order.entities.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.time.Instant;

public record OrderDTO(@NonNull Instant moment, @NotNull User client) {
}
