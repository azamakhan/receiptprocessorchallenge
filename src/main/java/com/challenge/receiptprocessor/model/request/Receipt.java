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
    @NotBlank(message = "Retailer name is missing and is required.")
    private String retailer;

    @NotNull(message = "Purchase date is missing and is required.")
    private LocalDate purchaseDate;

    @NotNull(message = "Purchase time is missing and is required.")
    private LocalTime purchaseTime;

    @NotEmpty(message = "Items is missing and at least one item is required.")
    private List<Item> items;

    @NotBlank(message = "Total is missing and is required.")
    private String total;
}
