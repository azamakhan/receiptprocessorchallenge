package com.challenge.receiptprocessor.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class Receipt {
    @NotBlank(message = "Retailer name is required")
    private String retailer;

    @NotNull(message = "Purchase date is required")
    private LocalDate purchaseDate;

    @NotNull(message = "Purchase time is required")
    private LocalTime purchaseTime;

    @NotEmpty(message = "At least one item is required")
    private List<Item> items;

    @NotBlank(message = "Total is required")
    private String total;
}
