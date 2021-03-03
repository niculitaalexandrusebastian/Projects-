package isp.lab7.safehome.exceptions;

public class TenantAlreadyExistsException extends Exception {
    String tenant;

    public TenantAlreadyExistsException(String tenant, String msg) {
        super(msg);
        this.tenant = tenant;
    }

    public String getT() {
        return tenant;
    }

}
