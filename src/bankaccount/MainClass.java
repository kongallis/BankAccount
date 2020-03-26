package bankaccount;

import java.util.ArrayList;

    /*
    Create a BankAccount class with variables number(int), amount(double), 
    name(String), active(boolean), transactions(ArrayList<String>)
    Add getters/setters
    Create methods deposit(), withdraw(). Do you need the setter for amount variable?
    Store each action (deposit, withdraw, creation) in the transactions list.
    If account doesn't have amount, what can you withdraw?
    Create a variable(accountsOpened) that counts the number of accounts opened. 
    This variable shows how many accounts have been opened.
    Create 3 contructors (default, name-number, all(except transactions)). 
    When created all will be active.
     */
    

public class MainClass {

    public static void main(String[] args) {
        
        BankAccount accountPeiraios = new BankAccount(1, 0.0, "Peiraios", true);
        BankAccount accountPeiraios2 = new BankAccount();
        accountPeiraios.deposit(100);
        accountPeiraios.withdraw(10);
        System.out.println(accountPeiraios.getTransactions());
        
        BankAccount accountEthniki = new BankAccount(2, "Ethniki");
        accountEthniki.deposit(500);
        Person jack = new Person("Jack");
        jack.addAccount(accountEthniki);
        
        jack.printAllBanksMoney();
        
    }
    
    


    
}
