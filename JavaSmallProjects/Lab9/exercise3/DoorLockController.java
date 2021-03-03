package isp.lab9.exercise3;

import isp.lab9.exercise3.exceptions.InvalidPinException;
import isp.lab9.exercise3.exceptions.TenantAlreadyExistsException;
import isp.lab9.exercise3.exceptions.TenantNotFoundException;
import isp.lab9.exercise3.exceptions.TooManyAttemptsException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface {
    private Map<Tenant, AccessKey> validAccess;
    private Door door;
    private List<AccessLog> accessLogs;
    private int nrOfTry;
    // private AccessKey MasterKey;
    private String Master_key;


    public DoorLockController() {
        this.validAccess = new HashMap<>();
        this.accessLogs = new ArrayList<>();
        this.door = new Door();
        nrOfTry = 0;
        this.Master_key = ControllerInterface.MASTER_KEY;
    }

    private static final String PIN_CORECT = "Pin Correct";
    private static final String PIN_INCORECT = "Pin Incorect";
    private static final String DOOR_LOCK = "Door locked";
    private static final String ADD_TENANT = "Add Tenant";
    private static final String NOT_ADD_TENANT = "Didn't add tenant";
    private static final String DELETE_TENANT = "Delete Tenant";
    private static final String NOT_DELETE_TENANT = "Not Delete Tenant";


    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        //  nrOfTry = 0;
        Tenant tenant = new Tenant();
        AccessKey accessKey = new AccessKey(pin);
        for (Map.Entry<Tenant, AccessKey> aEntry : validAccess.entrySet()) {
            if (validAccess.values().contains(new AccessKey(pin)))
                tenant = aEntry.getKey();

        }
        System.out.println("Enter pin:");
        if (door.getStatus() == DoorStatus.CLOSE) {
            while (door.getStatus() == DoorStatus.CLOSE) {


                if (pin != null && ((validAccess.values().contains(accessKey) && nrOfTry < 3) || pin.equals(ControllerInterface.MASTER_KEY))) {
                    if (!pin.equals(this.Master_key)) {
                        accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), PIN_CORECT, door.getStatus(), MASTER_TENANT_NAME + "has unlocked the door"));
                    }
                    if (pin.equals(this.Master_key)) {
                        accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), PIN_CORECT, door.getStatus(), tenant.getName() + "has unlocked the Door!"));
                    }
                    System.out.println("The Door is unlocked");
                    door.unlockDoor();
                    nrOfTry = 0;
                    return door.getStatus();


                } else {

                    if (nrOfTry >= 3) {
                        accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), DOOR_LOCK, door.getStatus(), "Door locked"));
                        throw new TooManyAttemptsException("TooManyAttemptsException");
                    }
                }
                if (!validAccess.values().contains(accessKey))
                    nrOfTry++;
                if (nrOfTry < 3 && !validAccess.values().contains(accessKey)) {
                    //nrOfTry++;
                    accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), PIN_INCORECT, door.getStatus(), "Pin incorrect!"));
                    throw new InvalidPinException(pin, "Invalid Pin!!");
                }

            }
        } else {


            while (door.getStatus() == DoorStatus.OPEN) {
                if (pin != null && ((validAccess.values().contains(accessKey) && nrOfTry < 3) || pin.equals(ControllerInterface.MASTER_KEY))) {
                    door.lockDoor();
                    nrOfTry = 0;
                    accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), PIN_CORECT, door.getStatus(), tenant.getName() + "has locked the Door!"));
                    System.out.println("The door is locked");
                    return door.getStatus();
                } else {


                    if (nrOfTry >= 3) {
                        accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), DOOR_LOCK, door.getStatus(), "Door locked"));
                        throw new TooManyAttemptsException("TooManyAttemptsException");
                    }
                }
                if (!validAccess.values().contains(accessKey))
                    nrOfTry++;
                if (nrOfTry < 3 && !validAccess.values().contains(accessKey)) {
                    // nrOfTrylock++;
                    accessLogs.add(new AccessLog(tenant.getName(), LocalDateTime.now(), PIN_INCORECT, door.getStatus(), "Pin incorrect!"));
                    throw new InvalidPinException(pin, "Invalid Pin!!");
                }


            }
        }
        return door.getStatus();


    }


    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        Tenant tenant = new Tenant(name);
        if (tenant != null && validAccess.containsKey(tenant)) {
            accessLogs.add(new AccessLog(name, LocalDateTime.now(), NOT_ADD_TENANT, door.getStatus(), "Tenant not added"));
            throw new TenantAlreadyExistsException(name, " Tenant Already exist");
        } else if (tenant != null && pin != null) {
            System.out.println("New tenant add. TenantName: " + name + " and pin:" + pin);
            AccessKey newpin = new AccessKey(pin);
            validAccess.put(tenant, newpin);
            accessLogs.add(new AccessLog(name, LocalDateTime.now(), ADD_TENANT, door.getStatus(), "Tenant add"));


        }

    }


    public void removeTenant(String name) throws Exception {
        Tenant tenant = new Tenant(name);
        if (name != null && !validAccess.containsKey(tenant)) {
            accessLogs.add(new AccessLog(name, LocalDateTime.now(), NOT_DELETE_TENANT, door.getStatus(), "Tenant not deleted"));
            throw new TenantNotFoundException(name, " Not Found");
        } else if (name != null && validAccess.containsKey(tenant)) {
            System.out.println("Tenant removed");
            accessLogs.add(new AccessLog(name, LocalDateTime.now(), DELETE_TENANT, door.getStatus(), "Tenant  deleted"));
            validAccess.keySet().remove(tenant);
        }
    }

    public List<AccessLog> getAccessLogs() {
        return accessLogs;

    }


}
