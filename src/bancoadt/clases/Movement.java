/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt.clases;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author 2dam
 */
public class Movement implements Serializable {
    private long id;

    
    private LocalDate timeStamp;
    private float amount,balance;
    private String description;
    public void setId(long id) {
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

    public long getId() {
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
    
    public  void getDatos(){
        System.out.println(this.getId());
        System.out.println(this.getDescription());
        System.out.println(this.getAmount());
        System.out.println(this.getBalance());
        System.out.println(this.getTimeStamp());
    }
}
