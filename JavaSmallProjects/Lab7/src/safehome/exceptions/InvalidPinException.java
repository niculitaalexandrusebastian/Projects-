package isp.lab7.safehome.exceptions;

public class InvalidPinException extends Exception {
    String pin;

    public InvalidPinException(String pin, String msg) {
        super(msg);
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }
}
