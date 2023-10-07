class BankAccount{
private double checkingBalance;
private double savingBalance;
private static int numberOfAccounts;
private static int totalAmount;

// constructor
public BankAccount(){
    this.checkingBalance= 0.0;
    this.savingBalance= 0.0;
    numberOfAccounts ++;
}
// getter and setter
public double getCheckingBalance(){
    return this.checkingBalance;
}
public void setCheckingBalance( double checkingBalance){
    this.checkingBalance = checkingBalance;
}
public double getSavingBalance(){
    return this.savingBalance;
}
public void setSavingBalance(double savingBalance){
    this.savingBalance = savingBalance;
    
}
public static int getNumberOfAccounts(){
  return numberOfAccounts;
}

public static void setNumberOfAccounts(int newNumberOfAccounts){
  numberOfAccounts = newNumberOfAccounts;
}

// methods
public void depositMoney(String typeOfAccount, double amount){
    if (typeOfAccount.equals ("checking")) {
        setCheckingBalance(getCheckingBalance() + amount);
        
    }
    else if (typeOfAccount.equals("saving")){
        setSavingBalance(getSavingBalance() + amount);
    }

    totalAmount += amount;
}

public void withdrawMoney (String typeOfAccount, double amount){

    if (typeOfAccount.equals("checking") ){

        if (getCheckingBalance()> amount){
            setCheckingBalance(getCheckingBalance()- amount);
            }
        else{
            System.out.println("Insufficient Funds!");
            }

    }
    else if (typeOfAccount.equals("saving") ){

        if (getSavingBalance()> amount){
            setSavingBalance(getSavingBalance()- amount);
            }
        else{
            System.out.println("Insufficient Funds!");
            }

    }
totalAmount-= amount;

}
public double getTotalBalance(){
    return(getCheckingBalance()+ getSavingBalance());
}
}