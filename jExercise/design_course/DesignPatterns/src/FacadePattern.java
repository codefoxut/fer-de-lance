import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;

public class FacadePattern {
    public static void main(String args[]){
        BankService myBankService = new BankService();
        int mySaving = myBankService.createBankAccount("saving", BigInteger.valueOf(500L));
        int myInvestment = myBankService.createBankAccount("investment", BigInteger.valueOf(1000L));

        myBankService.transferMoney(mySaving, myInvestment, BigInteger.valueOf(300L));
    }
    
}

interface IAccount {
    public void deposit(BigInteger amount);
    public void withdraw(BigInteger amount);
    public void transfer(IAccount toAccount, BigInteger amount);
    public int getAccountNumber();
}

class Investment implements IAccount {
    BigInteger balance;
    int accountNumber;

    public Investment(BigInteger amount){
        Random randGen = new Random();
        this.balance = amount;
        this.accountNumber = randGen.nextInt(100000);
    }

    public void deposit(BigInteger amount){
        this.balance = this.balance.add(amount);
        System.out.println("deposit amount " + amount + " new balance " + this.balance);
    }
    public void withdraw(BigInteger amount){
        this.balance = this.balance.subtract(amount);
        System.out.println("withdraw amount " + amount + " new balance " + this.balance);
    }
    public void transfer(IAccount toAccount, BigInteger amount){
        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("transfer amount " + amount);
        System.out.println("to account acc No. " + toAccount.getAccountNumber());
        System.out.println("this account balance " + this.balance);
    };
    public int getAccountNumber(){
        return this.accountNumber;
    }
}

class Saving implements IAccount {
    BigInteger balance;
    int accountNumber;

    public Saving(BigInteger amount){
        Random randGen = new Random();
        this.balance = amount;
        this.accountNumber = randGen.nextInt(100000);
    }
    public void deposit(BigInteger amount){
        this.balance = this.balance.add(amount);
        System.out.println("deposit amount " + amount + " new balance " + this.balance);
    }
    public void withdraw(BigInteger amount){
        this.balance = this.balance.subtract(amount);
        System.out.println("withdraw amount " + amount + " new balance " + this.balance);
    }
    public void transfer(IAccount toAccount, BigInteger amount){
        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("transfer amount " + amount);
        System.out.println("to account acc No. " + toAccount.getAccountNumber());
        System.out.println("this account balance " + this.balance);
    };
    public int getAccountNumber(){
        return this.accountNumber;
    }
}

class BankService {
    private Hashtable<Integer,IAccount> bankAccounts;

    public BankService() {
        this.bankAccounts = new Hashtable<Integer,IAccount>();
    }

    public int createBankAccount(String type, BigInteger initAmount) {
        IAccount newAccount = null;

        switch (type) {
            case "saving":
                newAccount = new Saving(initAmount);
                break;
            case "investment":
                newAccount = new Investment(initAmount);
                break;
            default:
                System.out.println("Invalid account type");
                break;

        }
        if (newAccount != null) {
            this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
            return newAccount.getAccountNumber();
        }
        return -1;
    }

    public void transferMoney (int to, int from, BigInteger amount) {
        IAccount toAccount = this.bankAccounts.get(to);
        IAccount fromAccount = this.bankAccounts.get(from);

        fromAccount.transfer(toAccount, amount);
    }


}




