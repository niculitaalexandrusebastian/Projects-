package isp.lab10.exercise1;

import java.util.List;

public class ATC {
    private List<Aircraft> aircrafts;

    public ATC(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void addAircraft(String id) {
        Aircraft newAircraft = new Aircraft(id);

        if (aircrafts.contains(newAircraft))
            System.out.println("The Aircraft with this id already exists!");
        else {
            aircrafts.add(newAircraft);
        }
    }

    public void sendCommand(String aircraftId, AtcCommand cmd) {
        for (Aircraft aircraft : aircrafts)
            if (aircraft.getId().equals(aircraftId))
                aircraft.receiveAtcCommand(cmd);
    }

    public void showAircrafts() {
        for (int i = 0; i < aircrafts.size(); i++)
            System.out.println("Aircraft " + i + "=" + aircrafts.get(i));

    }

    @Override
    public String toString() {
        return "ATC{" +
                "aircrafts=" + aircrafts +
                '}';
    }
}
