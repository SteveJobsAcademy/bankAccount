/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanager;

import java.util.ArrayList;

/**
 *
 * @author archimede
 */
public class Bank {
    public static int counter = 0;
    
    private String name;
    private int id;
    private double amount = 0;
    private int costOfSubscription = 5;
    private int costOfCommission = 2;
    
    private ArrayList<Account> accounts;
    
    
    public Bank(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
        this.id = ++counter;
    }
    
    public Bank(String name, double amount){
        this(name);
        this.amount = amount;
    }
    
    public void addAccount(String name, String surname){
        Account account = new Account(this.id, name, surname, -costOfSubscription);
        this.amount += costOfSubscription;
        this.accounts.add(account);
    }
    
    public void addAccount(String name, String surname, double amount){
        Account account = new Account(this.id, name, surname, amount - costOfSubscription);
        this.amount += costOfSubscription;
        this.accounts.add(account);
    }
    
    public double getAmountOfAccounts(){
        double total = 0;
        for (Account account: this.accounts){
            total += account.getAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Bank{" + "name=" + name + ", id=" + id + ", amount=" + amount + ", costOfSubscription=" + costOfSubscription + '}';
    }

    public int getId() {
        return id;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getCostOfCommission() {
        return costOfCommission;
    }

    public void setCostOfCommission(int costOfCommission) {
        this.costOfCommission = costOfCommission;
    }
    
    public Account getAccount(String iban){
        String[] parts = iban.split("-");
        int ibanBankId = Integer.parseInt(parts[0]);
        int ibanAccountId = Integer.parseInt(parts[1]);
        for(Account account: this.getAccounts()) {
            if (account.getId() == ibanAccountId){
                return account;
            }
        }
        return null;
    }
    
    

    
    
    
    
}
