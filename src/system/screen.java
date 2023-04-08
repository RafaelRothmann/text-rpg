package src.system;

import java.io.IOException;

public class screen {
    public static void clear() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else{
            new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
        }
    }
}
