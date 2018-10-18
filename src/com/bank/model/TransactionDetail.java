/*
 * *
 *   * Copyright (c) ION Trading UK Limited 2015
 *   * All Rights reserved.
 *
 */

package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDetail implements Comparable<TransactionDetail> {

    private final EntryType transactionType;
    private final String transactionId;
    private final LocalDateTime transactionDate;
    private final String narration;
    private final BigDecimal withdrawalAmount;
    private final BigDecimal depositAmount;
    private final BigDecimal closingBalance;

    public TransactionDetail(EntryType transactionType, String transactionId, String narration, BigDecimal withdrawalAmount, BigDecimal depositAmount, BigDecimal closingBalance) {
        this.transactionType = transactionType;
        this.transactionId = transactionId;
        this.transactionDate = LocalDateTime.now();
        this.narration = narration;
        this.withdrawalAmount = withdrawalAmount;
        this.depositAmount = depositAmount;
        this.closingBalance = closingBalance;
    }

    public void printEntry() {
        System.out.println("|| " + transactionDate + " | " + narration +
                " | " + roundAndFormatBigDecimal(withdrawalAmount) +
                " | " + roundAndFormatBigDecimal(depositAmount) +
                " | " + roundAndFormatBigDecimal(closingBalance) + " ||");
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "transactionType=" + transactionType +
                ", transactionId=" + transactionId +
                ", transactionDate=" + transactionDate +
                ", narration='" + narration + '\'' +
                ", withdrawalAmount=" + withdrawalAmount +
                ", depositAmount=" + depositAmount +
                ", closingBalance=" + closingBalance +
                '}';
    }

    private String roundAndFormatBigDecimal(BigDecimal amount) {
        return amount.setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString();
    }


    @Override
    public int compareTo(TransactionDetail o) {
        return this.transactionDate.compareTo(o.transactionDate);
    }
}