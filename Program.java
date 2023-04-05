import java.util.Scanner;
import java.lang.Math;
import persons.player;
import persons.guest;

public class Program {
    public static void main(String args[]) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        player pl = new player(1);
        char a;
        int i = 1;
        boolean janela = true;

        while (janela == true) {
            if (i != 1) {
                clear();
                System.out.println("O seu nível é " + pl.getLvl());
                System.out.println("A sua vida é " + pl.getVida());
                System.out.println();
            } else if (i == 1) {

            }

            i++;

            System.out.println("---Menu---");
            System.out.println("0 - Para sair");
            System.out.println("1 - Para sortear");
            System.out.print("Digite a sua opção: ");
            int jogo = sc.nextInt();
            int random = (int) ((Math.random() * 1) + 1);

            if (jogo == 0) {
                System.out.print("Você tem certeza (s/n)? ");
                char m = sc.next().charAt(0);

                if (m == 's' || m == 'S') {
                    janela = false;
                } else if (m == 'n' || m == 'N') {
                    System.out.println("Obrigado!");
                    System.out.print("Digite S para continuar...");
                    a = sc.next().charAt(0);
                } else {
                    System.out.println("Erro, reinicei o jogo :C");
                    System.out.println("Digite S para continuar...");
                    a = sc.next().charAt(0);
                }

            } else if (jogo == 1) {
                clear();
                switch (random) {
                    case 1:
                        guest gt = new guest(pl.getLvl());
                        System.out.println("Apareceu um Viajante!");
                        System.out.println("Quer saber mais sobre ele (s/n)? ");
                        char op = sc.next().charAt(0);

                        if (op == 's' || op  == 'y'){
                            System.out.println(gt);
                        } 

                        System.out.println();
                        System.out.println("O você aceita dar uma moeda para ele (s/n)? ");
                        char opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            int rdm = (int) ((Math.random() * 1) + 1);
                            gt.evento(rdm, pl);

                            int nivel = (int) (pl.getLvl());
                            System.out.println("Você ganhou XP, o seu nível agora está no " + nivel);

                        } else if (opcao == 'n') {
                            System.out.println("Que pena meu jovem!");
                        }

                        System.out.println("Digite S para continuar...");
                        a = sc.next().charAt(0);

                        break;
                    default:
                        System.out.println("Erro, reinicei o jogo :C");
                        System.out.println("Digite S para continuar...");
                        a = sc.next().charAt(0);
                        break;
                }
            }
        }
        sc.close();
    }

    public static void clear() {
        for (int i = 0; i <= 20; i++) {
            System.out.println();
        }
    }
}