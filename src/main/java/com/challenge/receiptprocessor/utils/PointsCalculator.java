package com.challenge.receiptprocessor.utils;

import com.challenge.receiptprocessor.model.request.Item;
import com.challenge.receiptprocessor.model.request.Receipt;

import java.time.LocalTime;

public class PointsCalculator {
    public static int calculatePoints(Receipt receipt) {
        int points = 0;

        // Rule 1: One point for every alphanumeric character in the retailer name
        points += receipt.getRetailer().replaceAll("[^A-Za-z0-9]", "").length();

        // Rule 2: 50 points if the total is a round dollar amount with no cents
        if (receipt.getTotal().matches("\\d+\\.00")) {
            points += 50;
        }

        // Rule 3: 25 points if the total is a multiple of 0.25
        double total = Double.parseDouble(receipt.getTotal());
        if (total % 0.25 == 0) {
            points += 25;
        }

        // Rule 4: 5 points for every two items on the receipt
        points += (receipt.getItems().size() / 2) * 5;

        // Rule 5: If the trimmed length of the item description is a multiple of 3...
        for (Item item : receipt.getItems()) {
            String description = item.getShortDescription().trim();
            if (description.length() % 3 == 0) {
                double price = Double.parseDouble(item.getPrice());
                points += Math.ceil(price * 0.2);
            }
        }

        // Rule 6: 6 points if the day in the purchase date is odd
        if (receipt.getPurchaseDate().getDayOfMonth() % 2 != 0) {
            points += 6;
        }

        // Rule 7: 10 points if the time of purchase is after 2:00pm and before 4:00pm
        LocalTime purchaseTime = receipt.getPurchaseTime();
        if (purchaseTime.isAfter(LocalTime.of(14, 0)) && purchaseTime.isBefore(LocalTime.of(16, 0))) {
            points += 10;
        }

        return points;
    }
}
