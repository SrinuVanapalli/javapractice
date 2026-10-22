import javax.swing.*;
import java.awt.event.*;

public class Button{
    public static void main(String[] args){
        JFrame frame = new JFrame("Button Example");

        JButton button = new JButton("click here");
        button.setBounds(75,100,100,50);
        JLabel label = new JLabel();
        label.setBounds(250,250,250,250);

        button.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent e){
                label.setText("you clicked the button wait 5 seconds");
                button.setEnabled(false);

                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label.setText("you can click the button again");
                        button.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
          });
        frame.add(button);
        frame.add(label);
        frame.setSize(450,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}