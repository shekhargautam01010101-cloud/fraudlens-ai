package com.fraudlens.fraudlens_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String beneficiary;
    private double amount;
    private LocalDateTime txnTime;
    private String device;
    private String location;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getBeneficiary() { return beneficiary; }
    public void setBeneficiary(String beneficiary) { this.beneficiary = beneficiary; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDateTime getTxnTime() { return txnTime; }
    public void setTxnTime(LocalDateTime txnTime) { this.txnTime = txnTime; }

    public String getDevice() { return device; }
    public void setDevice(String device) { this.device = device; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}