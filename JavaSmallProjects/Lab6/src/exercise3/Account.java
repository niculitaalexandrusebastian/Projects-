package isp.lab6.exercise3;

public class Account {
    private Card card;
    private String owner;
    private double balance;

    public Account(Card card, String owner, double balance) {
        this.card = card;
        this.owner = owner;
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "card=" + card +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
