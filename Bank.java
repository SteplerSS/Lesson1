/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestedclasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author BoostBrain
 */
public class Bank {
    
    public class Account{
        private String id;
        private String name;
        private int money;  
        private ArrayList<AccountOperation> operations =
                new ArrayList<AccountOperation>();
        
        public Account(String id, String name, int amount){
            this.id = id;
            this.name = name;
            this.money = amount;
        }
        
        public void open(){
            accounts.put(id, this);
        }
        
        public void close(){
            accounts.remove(id);
        }
    }
    
    public static class Banker{
        public Bank createBank(){
            return new Bank();
        }
    }
    
    private Bank(){
        
    }
    
    private HashMap<String, Account> accounts = new HashMap<String, Account>();

    public void putMoney(String id, int amount){
        Account account = accounts.get(id);
        if(account == null){
            return;
        }
        
        AccountOperation operation = new AccountOperation(){
            public Date getDate(){
                return new Date();
            }
            
            public int amount(){
                return amount;
            }
        };
        account.operations.add(operation);
    }
    
    public void getMoney(String id, int amount){
        Account account = accounts.get(id);
        if(account == null){
            return;
        }
        
        AccountOperation operation = new AccountOperation(){
            public Date getDate(){
                return new Date();
            }
            
            public int amount(){
                return -amount;
            }
        };
        account.operations.add(operation);
    }
}
