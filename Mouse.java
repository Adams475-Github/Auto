import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class Mouse {
    Robot r;
    public Mouse() {
        try {
            r = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
    }

    public void moveAndWait(Point p) throws InterruptedException {
        r.mouseMove(p.x, p.y);

    }

    public void clickC() throws InterruptedException {

        r.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(1000);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        System.out.println("clicked");
    }

    public void click(Point p){
        try {

            Scanner sc = new Scanner(System.in);

            r.mouseMove(p.x, p.y);

            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch (Exception evt) {
            System.err.println(evt.getMessage());
        }
    }

}
