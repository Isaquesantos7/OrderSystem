package com.OrderSystem.Order.DTOS;

import jakarta.validation.constraints.NotNull;

public record CategoryDTO(@NotNull String name) {
}
