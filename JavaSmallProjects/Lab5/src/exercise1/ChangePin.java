package isp.lab5.exercise1;

import javafx.scene.control.TextFormatter;

public class ChangePin extends Transaction {
    public String oldPin;
    public String newPin;

    public ChangePin(String old, String nw) {
        this.oldPin = old;
        this.newPin = nw;
    }

    public String execute() {
        if (this.oldPin.equals(this.newPin)) {
            System.out.println("New pin must be diferent!");
            return "";
        } else {
            account.getCard().setPin(newPin);
            System.out.println("Pin changed succesfully");
            return "";
        }
    }
}
