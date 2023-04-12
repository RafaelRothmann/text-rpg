package src.system;

import java.util.Scanner;
import java.io.IOException;

public class screen {
    public static Scanner sc = new Scanner(System.in);

    public static void clear() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else{
            new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
        }
    }

    public static void pause() throws InterruptedException, IOException{
        System.out.println();
        System.out.print("Digite S para continuar... ");
        char op = sc.next().charAt(0);
        if(op == 'S'){
            clear();
        } else{
            clear();
        }
    }
}
