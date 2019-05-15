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
public class Register {
    
    private ArrayList<Bank> banks = new ArrayList<>();
    
    public void addBank(Bank bank){
        this.banks.add(bank);
    }
    
    public void trasfer(String iban1, String iban2, double amount){
        String[] parts1 = iban1.split("-");
        int iban1BankId = Integer.parseInt(parts1[0]); 
        int iban1AccountId  = Integer.parseInt(parts1[1]);
        
        String[] parts2 = iban2.split("-");
        int iban2BankId = Integer.parseInt(parts2[0]);
        int iban2AccountId = Integer.parseInt(parts2[1]);
        
        Bank bank1 = this.getBank(iban1BankId);
        Bank bank2 = this.getBank(iban2BankId);
        
        boolean commission = iban1BankId != iban2BankId;
        
        for (Account account: bank1.getAccounts()){
            if (account.getId() == iban1AccountId){
                account.addAmount(-amount);
                if (commission) account.addAmount(-bank1.getCostOfCommission());
            }
        }
         for (Account account: bank2.getAccounts()){
            if (account.getId() == iban2AccountId){
                account.addAmount(amount);
            }
        }
        
        

        // 1-1
        // 2-4
        // 34-45
        // 3456789-34567890
        
    
    }
    
    public Bank getBank(int id) {
        for (Bank bank: this.banks){
            if (bank.getId() == id){
                return bank;
            }
        }
        return null;
    }
    
    
}
