package com.spring.boot.designpattern.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * First part of Clean Code with Java
 * Refactoring
 * Replace the logical condition using ENUM (if/else statements)
 * The code is clean enough to change faster than many if / else statements
 */
public enum TransactionType {
    BUY{
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.15), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    },

    SELL{
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.1), cashValue);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);
        }
    },

    DEPOSIT{
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.05), cashValue);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);
        }
    },

    WITHDRAWL{
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.20), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    };

    public abstract void doTransactionOperation(Account account, BigDecimal cashValue);


    BigDecimal calculateTax(BigDecimal percentage, BigDecimal cashvalue){
        return cashvalue
                .multiply(percentage)
                .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
    }
}
