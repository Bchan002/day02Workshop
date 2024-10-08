package bank;

public class FixedDepositAccount extends BankAccount {

    private float interest;
    private int duration;
    private boolean setInterest = false;
    private boolean setMonths = false;

    //Constructor overloading

    public FixedDepositAccount(String name,float balance){
        this(name,balance,3,6);
    }

    public FixedDepositAccount(String name,float balance, float interest){
        this(name,balance,interest,6);

    }

    public FixedDepositAccount(String name, float balance, float interest, int duration){
        super(name,balance);
        this.interest =interest;
        this.duration = duration;
    }

    //Methods getters and setters
    public void setInterest(float interest){
        try{
            if(setInterest == false){
                this.interest = interest;
                setInterest = true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.out.println("You can only set interest once!!!");
        }
         
    }

    public float getInterest(){
        return this.interest;
    }

    public void setMonths(int month){
        try {
            if(setMonths == false){
                this.duration= month;
                setMonths = true;
            } else{
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("You can only set months once!!!");
        }
    }

    public int getMonth(){
        return this.duration;
    }


    //Will not update the account's balance
    @Override 
    public void deposit(float amt){
        super.getBalance();
    }

    @Override 
    public void withdraw(float amt){
        super.getBalance();
    }

    @Override
    public float getBalance(){
        return super.getBalance()+(this.interest*this.duration);
    }
}
