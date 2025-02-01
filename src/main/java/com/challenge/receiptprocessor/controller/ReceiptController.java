package com.challenge.receiptprocessor.controller;

import com.challenge.receiptprocessor.model.request.Receipt;
import com.challenge.receiptprocessor.model.response.IdResponse;
import com.challenge.receiptprocessor.model.response.PointsResponse;
import com.challenge.receiptprocessor.service.ReceiptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private static final Logger log = LoggerFactory.getLogger(ReceiptController.class);

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/process")
    public ResponseEntity<IdResponse> processReceipt(@Valid @RequestBody Receipt receipt) {
        log.info("INFO: Inside processReceipt() method.");
        log.debug("DEBUG: Processing receipt for retailer: {}", receipt.getRetailer());
        String id = receiptService.processReceipt(receipt);
        log.info("INFO: Receipt processed successfully with ID: {}", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new IdResponse(id));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<PointsResponse> getPoints(@PathVariable String id) {
        log.info("INFO: Inside getPoints() method for ID: {}", id);
        int points = receiptService.getPoints(id);
        log.debug("DEBUG: Retrieved {} points for receipt ID: {}", points, id);
        return ResponseEntity.ok(new PointsResponse(points));
    }
}