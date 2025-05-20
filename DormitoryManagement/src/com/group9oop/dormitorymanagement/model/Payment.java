package com.group9oop.dormitorymanagement.model;

import java.time.LocalDate;

public class Payment {
    private Student student;
    private double amount;
    private LocalDate paymentDate;
    private boolean isPaid;

    public Payment(Student student, double amount, LocalDate paymentDate, boolean isPaid) {
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
    }

    public Student getStudent() {
        return student;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
