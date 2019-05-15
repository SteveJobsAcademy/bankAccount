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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bank bank1 = new Bank("BNL");
        Bank bank2 = new Bank("Monte Paschi");
        bank2.setCostOfCommission(6);
        Bank bank3 = new Bank("Unicredit", 1000.02);
        
        bank1.addAccount("Simone", "Aiello", 35);
        bank1.addAccount("Dario", "Laganà", 300000);
        
        bank2.addAccount("Carlo", "Leonardi", 1000);
        bank2.addAccount("Alessandro", "Bazzano", 100);
        bank2.addAccount("Matteo", "Annaro", 5000);
        
        bank3.addAccount("Davide", "Turzo", 10000);
        bank3.addAccount("Antonio", "Petralia", 1000);
        
        
        Register register = new Register();
        register.addBank(bank1);
        register.addBank(bank2);
        register.addBank(bank3);
        
        register.trasfer("1-0", "1-1", 30);
        System.out.println(bank1.getAccount("1-0"));
        System.out.println(bank1.getAccount("1-1"));
        
        register.trasfer("2-2", "3-6", 50);
        
        System.out.println(bank2.getAccount("2-2"));
        System.out.println(bank3.getAccount("3-6"));
        
    }
    
}
