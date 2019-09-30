import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SystemProcesses {

    public SystemProcesses(){

    }

    public boolean isLeagueRunning() {
        ArrayList<String> list = new ArrayList<String>();

        try {
            String line;
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }

        for(String s : list) {
            if(s.contains("League of Legends.exe")){
                return true;
            }

        }
        return false;
    }
}
