package isp.lab10.exercise1;

import java.util.Objects;

public class Aircraft implements Runnable {
    private String id;
    private int altitude;
    private boolean isLanded = false;
    private States states = States.ON_STAND;
    private long timeCruising;
    private long timeLanding;

    public Aircraft(String id) {

        this.id = id;

    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", altitude=" + altitude +
                ", isLanded=" + isLanded +
                ", states=" + states +
                ", timeCruising=" + timeCruising +
                ", timeLanding=" + timeLanding +
                '}';
    }

    @Override
    public void run() {
        isLanded = false;
        while (!isLanded) {
            switch (states) {

                case ON_STAND: {
                    System.out.println("In standing" + this);
                    synchronized (this) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case TAXING: {
                    try {
                        System.out.println("Taxing");
                        Thread.sleep(10_000L);
                        states = States.TAKING_OFF;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case TAKING_OFF: {
                    try {
                        System.out.println("Taking off");
                        Thread.sleep(5_000L);
                        states = States.ASCENDING;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case ASCENDING: {
                    try {
                        System.out.println("Ascending");
                        for (int i = 1; i <= altitude; i++) {
                            Thread.sleep(10_000L);
                        }
                        timeCruising = System.currentTimeMillis();
                        states = States.CRUISING;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case CRUISING: {
                    isLanded = true;
                    System.out.println("In cruising" + this);
                    break;

                }
                case DESCENDING: {
                    try {
                        timeLanding = System.currentTimeMillis();
                        System.out.println("Descending");
                        for (int i = 1; i <= altitude; i++) {
                            Thread.sleep(10_000L);
                        }
                        states = States.LANDED;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case LANDED: {
                    states = States.ON_STAND;
                    long time = timeLanding - timeCruising;
                    this.altitude = 0;
                    System.out.println("Time spent Cruising: " + time);
                    isLanded = true;
                    break;

                }

            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;
        return altitude == aircraft.altitude &&
                Objects.equals(id, aircraft.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, altitude);
    }

    public void receiveAtcCommand(AtcCommand atccommand) {
        if ((states.equals(States.ON_STAND) && (atccommand instanceof TakeoffCommand))) {
            states = States.TAXING;
            this.altitude = ((TakeoffCommand) atccommand).getAltitude();
            run();
            synchronized (this) {
                this.notify();
            }
        } else if (!states.equals(States.ON_STAND) && (atccommand instanceof TakeoffCommand)) {
            System.out.println("Aircraft is not in ON_STATND state.");
        } else if ((states.equals(States.CRUISING) && (atccommand instanceof LandCommand))) {
            states = States.DESCENDING;
            run();
        } else if (!states.equals(States.CRUISING) && (atccommand instanceof LandCommand)) {
            System.out.println("Aircraft is not in CRUISING state.");
        }


    }
}
