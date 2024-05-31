package com.OrderSystem.Order.DTOS;

import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String name, @NotNull String email, @NotNull String phone, @NotNull String password) {

}
