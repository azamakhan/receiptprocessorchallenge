package com.challenge.receiptprocessor.service;

import com.challenge.receiptprocessor.model.request.Receipt;
import com.challenge.receiptprocessor.utils.PointsCalculator;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final Map<String, Integer> receiptPoints = new ConcurrentHashMap<>();

    public String processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        int points = PointsCalculator.calculatePoints(receipt);
        receiptPoints.put(id, points);
        return id;
    }

    public int getPoints(String id) {
        return receiptPoints.getOrDefault(id, 0);
    }
}
