package isp.lab7.safehome.exceptions;

public class TenantNotFoundException extends Exception {
    String tenant;

    public TenantNotFoundException(String tenant, String msg) {
        super(msg);
        this.tenant = tenant;
    }

    public String getTenant() {
        return tenant;
    }


}
