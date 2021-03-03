package isp.lab9.exercise3;

import isp.lab9.exercise3.exceptions.InvalidPinException;
import isp.lab9.exercise3.exceptions.TooManyAttemptsException;

import javax.swing.*;
import java.awt.*;


public class GraphicInterface extends JFrame {
    private DoorLockController doorLockController;
    private JTextField textFieldenterPin;
    private JTextField textFieldDisplayStatus;
    private JButton button;


    public GraphicInterface(DoorLockController doorLockController) {
        this.doorLockController = doorLockController;
        setTitle("Interfata");
        setSize(280, 150); //set frames size in pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();//must do this
        JLabel label1 = new JLabel("Type enter pin:");
        button = new JButton("Enter Pin");
        textFieldenterPin = new JTextField();
        JLabel label2 = new JLabel("Door Status:");
        textFieldDisplayStatus = new JTextField();
        cp.setLayout(null);

        label1.setBounds(1, 10, 100, 20);
        textFieldenterPin.setBounds(110, 10, 100, 20);
        button.setBounds(70, 40, 100, 20);
        label2.setBounds(1, 80, 100, 20);
        textFieldDisplayStatus.setBounds(110, 80, 100, 20);


        cp.add(label1);
        cp.add(textFieldenterPin);
        cp.add(button);
        cp.add(label2);
        cp.add(textFieldDisplayStatus);

        this.enterpinInterface();
        show();

    }


    private void enterpinInterface() {
        this.button.addActionListener(e -> {
            String pin = textFieldenterPin.getText();

            try {
                DoorStatus doorStatus = this.doorLockController.enterPin(pin);

                if (doorStatus.toString().equals("OPEN")) {
                    this.textFieldDisplayStatus.setText("unlocked");
                } else {
                    this.textFieldDisplayStatus.setText("locked");
                }
            } catch (InvalidPinException | TooManyAttemptsException exception) {
                exception.printStackTrace();
            }

        });
    }

}
