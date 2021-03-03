package isp.lab6.exercise3;

public class ATM {
    private Bank bank;
    private Card card;
    private Transaction transaction;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void changePin(String oldPin, String newPin) {
        if (this.card != null) {
            transaction = new ChangePin(oldPin, newPin);
            transaction.account = bank.getAccountByCardId(this.card.getCardId());
            bank.executeTransaction(transaction);
        } else {
            System.out.println("There's no card inserted, can't process the operation.");
        }
    }

    public void withdraw(double amount) {
        if (this.card != null) {
            transaction = new WithdrawMoney(amount);
            transaction.account = bank.getAccountByCardId(this.card.getCardId());
            bank.executeTransaction(transaction);
            System.out.println("Withdrawal succesful.");
        } else {
            System.out.println("There's no card inserted, can't process operation.");
        }
    }

    public void checkMoney() {
        if (this.card != null) {
            transaction = new CheckMoney();
            transaction.account = bank.getAccountByCardId(this.card.getCardId());
            bank.executeTransaction(transaction);
        } else {
            System.out.println("There's no card inserted, can't process operation.");
        }
    }

    public boolean insertCard(Card card, String pin) {
        if (this.card == null) {
            if (card.getPin().equals(pin)) {
                this.card = card;
                System.out.println("The card has been inserted succesfully");
                return true;
            } else {
                System.out.println("Wrong PIN.");
            }
        } else {
            System.out.println("There is already a card inside the atm!");
        }
        System.out.println("Operation failed");
        return false;
    }

    public void removeCard() {
        System.out.println("Card with ID " + card.getCardId() + " removed succesfully");
        this.card = null;
    }

    public void usermenu() {
        System.out.println("1.Withdraw money");
        System.out.println("2.Change pin");
        System.out.println("3.Check balance");
        System.out.println("4.Remove card");
        System.out.println("5.Check PIN");
        System.out.println("6.Insert card");
        System.out.println("0.Exit");
        System.out.println("Choose your option:");
    }

}
