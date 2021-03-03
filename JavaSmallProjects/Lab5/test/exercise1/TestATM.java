package isp.lab5.exercise1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestATM {
    @Test
    public void testATM(){
        Card card =new Card("01","1111");
        Account[] account=new Account[1];
        account[0]=new Account(card,"Leo Messi",12345);
        Bank b= new Bank(account);
        ATM atm=new ATM(b);
        atm.insertCard(card,"1111");
        atm.changePin("1111","1234");
        assertEquals("1234",card.getPin());
       // assertEquals("1234", card.getPin());
        atm.withdraw(12340);

        assertEquals(5,account[0].getBalance(),0.01);






    }
}
