import java.awt.*;

public class AutoTFT {

    private Mouse mouse;
    private SystemProcesses sp;
    private Keyboard keyboard;
    private Point accept = new Point(967, 718);
    private Point queue = new Point(856, 836);
    private Point exitGame = new Point(825,536);
    private Point surrender = new Point(757, 873);
    private Point yesSurrender = new Point(856, 626);
    private long gameStart;

    public AutoTFT(){
        mouse = new Mouse();
        sp = new SystemProcesses();
        keyboard = new Keyboard();
        run();
    }

    public void run(){

        try{
            // initialized
            startQueue(); // starts the process
            // in game now
            inGame(); // loops forever

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startQueue() throws InterruptedException {
        if(!sp.isLeagueRunning()) {
            mouse.click(queue);
            Thread.sleep(5000);
            mouse.click(queue);
            Thread.sleep(3000);
            while(!sp.isLeagueRunning()){
                mouse.click(accept);
                Thread.sleep(8000);
            }
        }
    }

    private void requeue() throws InterruptedException {
        Thread.sleep(10000);
        mouse.click(queue);
        Thread.sleep(5000);
        mouse.click(queue);
        Thread.sleep(3000);
        while(!sp.isLeagueRunning()) {
            mouse.click(accept);
            Thread.sleep(2000);
        }
    }

    private void inGame() throws InterruptedException {
        gameStart = System.currentTimeMillis();

        while(true){
            //waiting to die
//            mouse.click(exitGame);
//            Thread.sleep(1000);
//            mouse.click(exitGame);
//            Thread.sleep(1000);
//            mouse.click(exitGame);

            if((System.currentTimeMillis() - gameStart) > 900000) {
                keyboard.pressEscape();
                mouse.click(surrender);
                Thread.sleep(3000);
                mouse.moveAndWait(yesSurrender);
                mouse.clickC();
                Thread.sleep(500);
                mouse.moveAndWait(yesSurrender);
                mouse.clickC();
                Thread.sleep(3000);
            }

            Thread.sleep(20000);

            if(!sp.isLeagueRunning()) {
                //successfully exited game
                requeue();
            }
        }
    }

    public static void main(String[] args){
        AutoTFT a = new AutoTFT();
    }
}
