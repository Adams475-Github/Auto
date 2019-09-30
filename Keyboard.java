import java.awt.*;
import java.awt.event.KeyEvent;

public class Keyboard {

    Robot r;

    public Keyboard() {
        try {
            r = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }

    }

    public void pressEscape() {
        r.keyPress(KeyEvent.VK_ESCAPE);
    }


}
