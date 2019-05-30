/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestedclasses;

/**
 *
 * @author BoostBrain
 */
public class NestedClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank.Banker banker = new Bank.Banker();
        Bank bank = banker.createBank();
        
        Bank.Account account = bank.new Account("qwe", "Boost Brain", 100000);
        account.open();
        bank.putMoney("qwe", 1000);
        bank.getMoney("qwe", 1000);
        
        account.close();
    }
    
}
