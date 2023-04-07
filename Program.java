import java.io.IOException;
import java.util.Scanner;

import system.game;
import system.screen;

public class Program {
    public static void main(String args[]) throws InterruptedException, IOException {

        screen.clear();
        Scanner sc = new Scanner(System.in);
        System.out.println("Lembrando que quanto maior o nível mais dificil será, mas mais atributos terá!");
        System.out.println("E quanto menor o nível mais facil será, mas menos atributos terá!");
        System.out.print("Digite o seu nível de dificuldade: ");
        int level = sc.nextInt();

        game jogo = new game(level);
        jogo.gameMode();

        sc.close();
    }
}
