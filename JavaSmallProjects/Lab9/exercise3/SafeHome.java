package isp.lab9.exercise3;


public class SafeHome {

    public static void main(String[] args) {


        DoorLockController doorLockController = new DoorLockController();
        try {
            doorLockController.addTenant("0000", "Alex");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            doorLockController.addTenant("1111", "Cristi");
        } catch (Exception e) {
            System.out.println(e);
        }
        GraphicInterface graphicInterface = new GraphicInterface(doorLockController);


    }


}





