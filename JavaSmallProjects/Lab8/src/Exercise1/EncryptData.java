package isp.lab8.Exercise1;

import java.io.*;
import java.time.LocalDateTime;

public class EncryptData {

    public EncryptData(){
    }

    public void createEncrypt(String cale){

        try{

            FileInputStream inputStream=new FileInputStream(cale);
            String name="exercise"+LocalDateTime.now().getMonth()+LocalDateTime.now().getMinute()+LocalDateTime.now().getSecond()+".enc";
            FileOutputStream outputStream=new FileOutputStream (name);

            int c;
            int x=name.length();

            while((c=inputStream.read())!= -1){
                c=c-x;
                outputStream.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

