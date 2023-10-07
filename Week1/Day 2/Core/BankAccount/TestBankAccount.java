public class TestBankAccount {
  public static void main(String[] args){
    BankAccount user1 = new BankAccount();
    BankAccount user2 = new BankAccount();

    user1.depositMoney("checking", 300);
    user2.depositMoney("saving", 1000);
    user2.depositMoney("checking", 50000);
    user1.withdrawMoney("checking", 320);
    user2.withdrawMoney("saving", 200);
    user1.getTotalBalance();
    user2.getTotalBalance();
System.out.println(user1.getTotalBalance());
System.out.println(user2.getTotalBalance());
System.out.println(BankAccount.getNumberOfAccounts());
}  
}
