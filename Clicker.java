import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
class Clicker {
    // Frame 
    static JFrame f;

    // textField 
    static TextField x, y, x1, y1;

    // default constructor 
    Clicker()
    {
    }

    // main function 
    public static void main(String args[])
    {
        // object of class 
        robomouse1 rm = new robomouse1();
        try {
            Robot r = new Robot();
            Scanner sc = new Scanner(System.in);

            System.out.println("x: ");
            int x = sc.nextInt();
            sc.nextLine();
            System.out.println("y: ");
            int y = sc.nextInt();

            r.mouseMove(x, y);

            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch (Exception evt) {
            System.err.println(evt.getMessage());
        }

    }

} 