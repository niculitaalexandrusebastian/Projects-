package isp.lab5.exercise1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestBank {
    @Test
    public void testBank(){
        Account[] account=new Account[1];
        Card c= new Card("01","1234");
        account[0]=new Account(c,"Lionel Messi",100000);
        Bank b=new Bank(account);
        assertEquals(account[0],b.getAccount(0));
        assertEquals(account[0],b.getAccountByCardId("01"));



    }
}
