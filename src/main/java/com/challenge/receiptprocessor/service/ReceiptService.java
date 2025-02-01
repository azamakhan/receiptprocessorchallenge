package com.challenge.receiptprocessor.service;

import com.challenge.receiptprocessor.model.request.Receipt;

public interface ReceiptService {
    String processReceipt(Receipt receipt);
    int getPoints(String id);
}
