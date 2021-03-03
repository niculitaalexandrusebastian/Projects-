package isp.lab5.exercise1;

public class CheckMoney extends Transaction {
    public String execute(){
        System.out.println("The curent amount is:"+account.getBalance());
        return "";
    }
}
