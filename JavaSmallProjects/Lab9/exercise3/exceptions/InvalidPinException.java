package isp.lab9.exercise3.exceptions;

public class InvalidPinException extends Exception {
    String pin;

    public InvalidPinException(String pin, String msg) {
        super(msg);
        this.pin = pin;
    }

}
