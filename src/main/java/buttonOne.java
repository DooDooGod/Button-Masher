import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class buttonOne extends Thread implements ActionListener

{
    public static boolean isRunning=false;

    public static Thread thread1;

    public static Robot robot;

    public static int milisec=45;


    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //Methods


    public void run()
    {

        ArrayList<Character> buttons=getCharacter();

        int delay=getSec();

        buttonOne.robot.delay(3000);
        while (buttonOne.isRunning) {

            for (char n : buttons) {
                int keycode = KeyEvent.getExtendedKeyCodeForChar(n);
                robot.keyPress(keycode);
                robot.delay(5);
                robot.keyRelease(keycode);
                robot.delay(delay);
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(!isRunning) {
            RobotMain.startButton.setText("Press to Stop");
            isRunning = true;
            thread1 = new Thread(this);
            thread1.start();

        }
        else if(isRunning)
        {
            RobotMain.startButton.setText("Press to Start");
            isRunning=false;

          }
        }



    public  int getSec()
    {
        int sec;
        Scanner DelayScanner=new Scanner(RobotMain.Delay.getText());

        if(DelayScanner.hasNextInt())
        {
            sec = DelayScanner.nextInt();
            if (sec > 0)
            {
                milisec = sec * 1000;
            }
        }
        else if(!DelayScanner.hasNextInt())
        {
            milisec=45;
        }
        return milisec;
    }



    public  ArrayList<Character> getCharacter()
    {
        String CharAsString;
        Scanner CharScanner=new Scanner(RobotMain.characterField.getText());
        ArrayList<Character> MashingChar=new ArrayList<>();

        if(CharScanner.hasNext())
        {
            CharAsString=CharScanner.nextLine();
            for (int i = 0; i < CharAsString.length(); i++) {
                MashingChar.add(CharAsString.charAt(i));
            }
        }

        return MashingChar;
    }

    }

