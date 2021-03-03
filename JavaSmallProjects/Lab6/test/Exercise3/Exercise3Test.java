package isp.lab6.Exercise3;

import isp.lab6.exercise3.ATM;
import isp.lab6.exercise3.Account;
import isp.lab6.exercise3.Bank;
import isp.lab6.exercise3.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Exercise3Test {
    @Test

    public void testATM(){
        Card card =new Card("01","1111");
       ArrayList<Account> account=new ArrayList<>();
        account.add(new Account(card,"Leo Messi",12345));
        Bank b= new Bank(account);
        ATM atm=new ATM(b);
        atm.insertCard(card,"1111");
        atm.changePin("1111","1234");
        assertEquals("1234",card.getPin());
        // assertEquals("1234", card.getPin());
        atm.withdraw(12340);

        assertEquals(5,account.get(0).getBalance(),0.01);

    }

    @Test
    public void testBank(){
        ArrayList<Account> account=new ArrayList<>();
        Card c= new Card("01","1234");
        account.add(new Account(c,"Lionel Messi",100000));
        Bank b=new Bank(account);
        assertEquals(account.get(0),b.getAccount(0));
        assertEquals(account.get(0),b.getAccountByCardId("01"));



    }




}