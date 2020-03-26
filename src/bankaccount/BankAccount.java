package bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
public class BankAccount {

    private int number;
    private double amount;
    private String name;
    private boolean active;
    private List<String> transactions = new ArrayList();
    private static int accountsOpened;

    public BankAccount() {
        accountsOpened++;
        transactions.add("Account oppened");
    }

    public BankAccount(int number, String name) {
        this();
        this.number = number;
        this.name = name;

    }

    public BankAccount(int number, double amount, String name, boolean active) {
        this(number, name);
        this.amount = amount;
        this.active = active;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

//We do not need a setter.
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getTransactions() {
        return transactions;
    }

//    public void setTransactions(List<String> transactions) {
//        this.transactions = transactions;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.number;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + (this.active ? 1 : 0);
        hash = 13 * hash + Objects.hashCode(this.transactions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        if (this.number != other.number) {
            return false;
        }
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.transactions, other.transactions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "number=" + number + ", amount=" + amount + ", name=" + name + ", active=" + active + ", transactions=" + transactions + '}';
    }
    
    private void create() {
        transactions.add("Create bank account with ID: " + number + " and name: " + name);
            }

    public double deposit(double depositAmount) {
        this.amount += depositAmount;
        transactions.add("+" + depositAmount);
        System.out.println("Total amount after transaction: " + amount);
        return this.amount;
    }

    public double withdraw(double poso) {
        if (this.amount < poso) {
            System.out.println("You don't have enough money.");
            System.out.println("You can withdraw: " + (this.amount - poso));
        } else {
            this.amount -= poso;
            transactions.add("-" + poso);
            System.out.println("Total amount after transaction: " + amount);
            
        }
        return this.amount;

    }

}
