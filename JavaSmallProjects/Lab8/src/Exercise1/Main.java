package isp.lab8.Exercise1;


public class Main {

    public static void main(String[] args) {
        String chooseOperation = args[0];
        String filename = args[1];


        if (chooseOperation.equals("encrypt")) {

            EncryptData encryptData = new EncryptData();
            encryptData.createEncrypt(filename);

        }
        if (chooseOperation.equals("decrypt")) {
            DecryptData decryptData = new DecryptData();
            decryptData.createDecrypt(filename);
        }

    }
}
