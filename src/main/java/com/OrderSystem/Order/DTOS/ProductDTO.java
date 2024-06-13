package com.OrderSystem.Order.DTOS;

import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotNull String name, String description, @NotNull Double price, String imgUrl) {
}
