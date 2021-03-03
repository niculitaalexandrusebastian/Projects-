package isp.lab6.exercise3;

public class CheckMoney extends Transaction {
    public String execute(){
        System.out.println("The curent amount is:"+account.getBalance());
        return "";
    }
}
