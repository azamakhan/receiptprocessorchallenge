package com.challenge.receiptprocessor.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Item {
    @NotBlank(message = "Short description is missing and is required.")
    private String shortDescription;

    @NotBlank(message = "Price is missing and is required.")
    private String price;
}
