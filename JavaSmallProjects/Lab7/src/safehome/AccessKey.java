package isp.lab7.safehome;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Objects;

public class AccessKey {
    private String pin;

    public AccessKey() {
    }

    public AccessKey(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "AccessKey{" +
                "pin='" + pin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccessKey)) return false;
        AccessKey accessKey = (AccessKey) o;
        return Objects.equals(pin, accessKey.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin);
    }
}
