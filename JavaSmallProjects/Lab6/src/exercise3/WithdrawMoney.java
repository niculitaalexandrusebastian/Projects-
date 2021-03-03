package isp.lab6.exercise3;

public class WithdrawMoney extends Transaction {
    public double amount;

    WithdrawMoney(double amount) {
        this.amount = amount;
    }

    public String execute() {
        double newBalance = account.getBalance() - amount;
        if (newBalance >= 0) {
            account.setBalance(newBalance);
            return "";
        } else {
            return "Your can't extract money because your don't have enough ";
        }
    }
}
