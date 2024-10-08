package bank;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class BankAccount {
    //Members/Attributes
    private final String accountName; //read only
    private final String accountNumber; //read only
    private float balance;
    private ArrayList<String> transactionsList = new ArrayList<>();
    private Boolean ifClose = false; 
    private Date accountCreated;
    private Date accountClosed;

    
    //Constructor Overloading
    public BankAccount(String accountName){
        this(accountName,0); //Set once in constructor
         
    }

    public BankAccount(String accountName, float balance){
        this.accountName = accountName;
        this.balance = balance;
        this.accountNumber = this.setAccountNumber();
        
    }

    //Methods -Setters and Getters
    public String getName(){
        return this.accountName;
    }

    public String getAccountNumber(){
         return this.accountNumber;
    }


    public float getBalance(){
        return this.balance;
    }

    public String getTransactions(){
        return transactionsList.toString() + "\n";
    }

    public Date getOpenDate(){
        return this.accountCreated;
    }

    public Date getCloseDate(){
        return this.accountClosed;
    }

    private final String setAccountNumber(){
        Random random = new Random();
        String[] account = new String[10];
        String uniqueNumber = " ";
        for(int i =0; i<10; i++){
            int randomNumber = random.nextInt(10);
            account[i] = String.valueOf(randomNumber);
        }

        //add all the number in string together
        for(String number:account){
            uniqueNumber += number;
        }
      
        return uniqueNumber;
         
    }

    public Date setOpenAccountDate(){
        this.accountCreated = new Date();
        ifClose = false;
        return this.accountCreated;
    }

    public Date setClosedAccountDate(){
        this.accountClosed = new Date();
        ifClose = true;
        return this.accountClosed;
    }


    //Methods for functionality

    public void deposit(float amount){
        //String print = " ";
        try{ 
            if(amount<=0 || this.ifClose == true){
                throw new IllegalArgumentException();
            } else {
                this.balance +=amount;
                transactionsList.add("Deposit " + String.valueOf(amount) + " at " + new Date());
            }

        } catch(IllegalArgumentException e){
            System.out.println("You have entered either a negative amount or your account is closed");
        }
    }


    public void withdraw(float amount){
        try{ 
            if(amount<=0 || this.ifClose == true){
                throw new IllegalArgumentException();
            } else {
                this.balance -=amount;
                transactionsList.add("Withdraw " + String.valueOf(amount) + " at " + new Date());
            }

        } catch(IllegalArgumentException e){
            System.out.println("You have entered either a negative amount or your account is closed");
        }
    }
    
}
