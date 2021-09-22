/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt.clases;

import java.time.LocalDate;
import java.util.Enumeration;

/**
 *
 * @author Steven,Irkus,Unai y Adrian
 */
public class Account {
    private int id;
    private String description;
    private float balance, creditLine, beginBalance;
    private LocalDate beginBalanceTimeStamp;
    private Enumeration type;

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public float getBalance() {
        return balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public LocalDate getBeginBalanceTimeStamp() {
        return beginBalanceTimeStamp;
    }

    public Enumeration getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public void setBeginBalanceTimeStamp(LocalDate beginBalanceTimeStamp) {
        this.beginBalanceTimeStamp = beginBalanceTimeStamp;
    }

    public void setType(Enumeration type) {
        this.type = type;
    }
}
