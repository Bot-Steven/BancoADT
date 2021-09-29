/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt.clases;

import java.time.LocalDate;

/**
 *
 * @author Steven,Irkus,Unai y Adrian
 */
public class Movement {
    
    private int id;
    private LocalDate timeStamp;
    private float amount,balance;
    private String description;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public float getAmount() {
        return amount;
    }

    public float getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }
    
}
