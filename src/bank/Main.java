package bank;

public class Main {
    public static void main(String[] args){

        // BankAccount bank = new BankAccount("Benjamin Chan");
        // System.out.println(bank.getBalance());
        // bank.deposit(100);
        // System.out.println(bank.getTransactions());
        // System.out.println(bank.getBalance());


        // bank.setClosedAccountDate();
        // bank.deposit(100);
        // System.out.println(bank.getTransactions());

        // bank.setOpenAccountDate();
        // bank.deposit(50);
        // System.out.println(bank.getTransactions());
        // System.err.println(bank.getBalance());

        FixedDepositAccount fixed = new FixedDepositAccount("Benjamin", 1000,10,6);
        //System.out.println(fixed.getAccountNumber());
        System.out.println(fixed.getInterest());
        fixed.setInterest(20);
        //Shows that only can setInterest once!
        fixed.setInterest(30);
        fixed.setMonths(5);
        //Same, only can set months once!
        fixed.setMonths(4);
        System.out.println(fixed.getMonth());
        System.out.println(fixed.getInterest());

        //Deposit and withdraw, shouldnt affect the balance
        fixed.deposit(200);
        fixed.withdraw(100);
        System.out.println(fixed.getBalance());


        BankAccount fixedDeposit = new FixedDepositAccount("Benjamin Chan", 1000);
        //Will not add since it being overriden
        fixedDeposit.deposit(200);
        System.out.println(fixedDeposit.getBalance());
        fixedDeposit.setOpenAccountDate();
        System.out.println(fixedDeposit.getOpenDate());

        
       
        

    }
    
}
