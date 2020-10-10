import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class RobotMain
{
    public static JFrame frame;
    public static JPanel panel;

    public static buttonOne b1=new buttonOne();

    public static JButton startButton;

    public static JTextField Delay;
    public static JTextField characterField;

    public static JLabel force_label;
    public static JLabel char_label;
    public static JLabel sec_label;
    public static GridBagConstraints gc;
    public static void main(String[]args)
    {

        startButton=new JButton("Press to Start");
        startButton.addActionListener(b1);

        gc=new GridBagConstraints();

        force_label=new JLabel("Close the Window To Force Stop the Program");
        sec_label=new JLabel("Enter Delay In Seconds");
        char_label=new JLabel("Enter Buttons to be Mashed");

        characterField =new JTextField(3);
        Delay =new JTextField(3);

        panel=new JPanel(new GridBagLayout());



        //character label
        gc.insets=new Insets(-60,0,30,0);
        gc.gridy=1;
        panel.add(char_label,gc);

        //character textfield
        gc.insets=new Insets(0,0,50,0);
        gc.gridy=2;
        panel.add(characterField,gc);

        //delay label
        gc.gridy=3;
        gc.insets=new Insets(-30,0,0,0);
        panel.add(sec_label,gc);

        //delay textfield
        gc.gridy=4;
        gc.insets=new Insets(0,0,0,0);
        panel.add(Delay,gc);

        //startbutton
        gc.gridy=5;
        gc.insets=new Insets(50,0,0,0);
        panel.add(startButton,gc);

        //forcestop label
        gc.gridy=6;
        gc.insets=new Insets(0,0,-100,0);
        panel.add(force_label,gc);


        panel.setBackground(Color.white);

        frame=new JFrame();
        frame.setSize(600,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



}
