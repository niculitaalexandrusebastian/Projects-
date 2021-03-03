package isp.lab5.exercise1;

public class Bank {
    private Account[] account = new Account[11];


    public Bank(Account[] account) {
        this.account = account;
    }

    public Account getAccount(int i) {
        return account[i];
    }

    public Account getAccountByCardId(String cardId) {
        for (int i = 0; i < account.length; i++)
            if (account[i].getCard().getCardId().equals(cardId)) {
                return account[i];
            }
        return null;
    }

    public String executeTransaction(Transaction t) {
        return t.execute();
    }


}
