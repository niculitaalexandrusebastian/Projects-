package isp.lab7.safehome;

import java.util.Objects;

public class Door {
    private DoorStatus status;

    public Door() {
        this.status = DoorStatus.CLOSE;
    }

    public DoorStatus lockDoor() {
        return this.status = DoorStatus.CLOSE;
    }

    public DoorStatus unlockDoor() {
        return status = DoorStatus.OPEN;
    }

    public DoorStatus getStatus() {
        return status;
    }

    public void setStatus(DoorStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Door{" +
                "status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Door)) return false;
        Door door = (Door) o;
        return status == door.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

}
