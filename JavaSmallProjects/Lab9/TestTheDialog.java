package isp.lab9;

import javax.swing.*;
import java.awt.event.*;

public class TestTheDialog extends JFrame implements ActionListener{
    JButton myButton = null;

    public TestTheDialog() {
        setTitle("Test Dialog");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myButton = new JButton("Test the dialog!");
        myButton.addActionListener(this);
        setLocationRelativeTo(null);
        add(myButton);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(myButton == e.getSource()) {
            System.err.println("Opening dialog.");
            CustomDialog myDialog = new CustomDialog(this, true, "Do you like Java?");
            System.err.println("After opening dialog.");
            if(myDialog.getAnswer()) {
                System.err.println("The answer stored in CustomDialog is 'true' (i.e. user clicked yes button.)");
            }
            else {
                System.err.println("The answer stored in CustomDialog is 'false' (i.e. user clicked no button.)");
            }
        }
    }

    public static void main(String argv[]) {
        TestTheDialog tester = new TestTheDialog();
    }
}

class CustomDialog extends JDialog implements ActionListener {
    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;
    private boolean answer = false;
    public boolean getAnswer() { return answer; }

    CustomDialog(JFrame frame, boolean modal, String myMessage) {
        super(frame, modal);
        myPanel = new JPanel();
        getContentPane().add(myPanel);
        myPanel.add(new JLabel(myMessage));
        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        myPanel.add(yesButton);
        noButton = new JButton("No");
        noButton.addActionListener(this);
        myPanel.add(noButton);
        pack();
        setLocationRelativeTo(frame);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(yesButton == e.getSource()) {
            System.err.println("User chose yes.");
            answer = true;
            setVisible(false);
        }
        else if(noButton == e.getSource()) {
            System.err.println("User chose no.");
            answer = false;
            setVisible(false);
        }
    }
}
