/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanager;

/**
 *
 * @author archimede
 */
public class Account {
    private static int counter = 0;
    private double amount = 0;
    private int id;
    private String name;
    private String surname;
    private String iban;
    private int bankId;
    
    public Account(int bankId, String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = counter++;
        this.bankId = bankId;
        this.iban = this.bankId + "-" + this.id;
    }
    
    public Account(int bankId, String name, String surname, double amount){
        this(bankId, name, surname);
        this.amount = amount;
        System.out.println(this);
    }

    public double getAmount() {
        return amount;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" + "amount=" + amount + ", name=" + name + ", surname=" + surname + ", iban=" + iban + '}';
    }

   
    
    
    
    
    
    
    
    
    
}
