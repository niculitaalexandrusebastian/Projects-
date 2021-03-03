package isp.lab8.Exercise1;

import java.io.*;
import java.time.LocalDateTime;

public class DecryptData {
    public DecryptData() {
    }

    public void createDecrypt(String name) {
        int x;
        String finalname = null;
        x = name.length();
        int finalnamelength;
        finalnamelength=x-4;
        finalname = name.substring(0, finalnamelength);
        String enc=null;
        enc=name.substring(x-3);

        if(enc.equals("enc")){
            try {
                FileInputStream fileInputStream = new FileInputStream(name);
                FileOutputStream fileOutputStream = new FileOutputStream(finalname + ".dec");
                int c;
                while ((c = fileInputStream.read()) != -1) {
                    c = c +x;
                    fileOutputStream.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

