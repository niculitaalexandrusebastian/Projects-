package isp.lab6.exercise3;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> account = new ArrayList<>();


    public Bank(ArrayList<Account> account) {
        this.account = account;
    }

    public Account getAccount(int i) {
        return account.get(i);
    }

    public Account getAccountByCardId(String cardId) {
        for (int i = 0; i < account.size(); i++)
            if (account.get(i).getCard().getCardId().equals(cardId)) {
                return account.get(i);
            }
        return null;
    }

    public String executeTransaction(Transaction t) {
        return t.execute();
    }
}
