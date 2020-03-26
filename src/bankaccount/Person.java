
package bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Person {
    
    private final String name;
    private List<BankAccount> accounts;

    public Person(String name) {
        this.name = name;
    }

    public List<BankAccount> getAccount() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        if (accounts == null) {
            accounts = new ArrayList();
        }
        accounts.add(account);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.accounts);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.accounts, other.accounts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", accounts=" + accounts + '}';
    }
    
    public void printAllBanksMoney() {
        double totalAmount = 0;
        for (BankAccount account : accounts) {
            totalAmount += account.getAmount();
        }
        System.out.println("Name: " + name + " has a total amount of " + totalAmount);
    }
    
}
