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
        char opcao;

        while (janela == true) {
            if (i != 1) {
                clear();
                System.out.println("Nível: " + (int) (pl.getLvl()));
                System.out.println("Vida: " + pl.getVida());
            } else if (i == 1) {
                System.out.println("Seja Bem-vindo ao rpg de texto!");
            }
            i++;
            System.out.println();
            System.out.println("---Menu---");
            System.out.println("0 - Para sair");
            System.out.println("1 - Para sortear");
            System.out.print("Digite a sua opção: ");
            int jogo = sc.nextInt();
            int random = (int) ((Math.random() * 1) + 1);

            if (jogo == 0) {
                System.out.print("Você tem certeza (s/n)? ");
                opcao = sc.next().charAt(0);

                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    janela = false;
                    break;
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Obrigado!");
                    System.out.print("Digite S para continuar...");
                    a = sc.next().charAt(0);
                    continue;
                } else {
                    System.out.println("Erro, reinicei o jogo :C");
                    System.out.println("Digite S para continuar...");
                    a = sc.next().charAt(0);
                    break;
                }

            } else if (jogo == 1) {
                clear();
                switch (random) {
                    case 1:
                        guest gt = new guest(pl.getLvl());
                        System.out.println("Apareceu um Viajante!");
                        System.out.println("Quer saber mais sobre ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y'){
                            System.out.println();
                            System.out.println("O Viajante é um misterioso personagem que percorre diferentes lugares em busca de novas aventuras e experiências.");
                            System.out.println();
                            System.out.println("Ele é conhecido por oferecer uma troca curiosa: se você der uma moeda a ele, o Viajante irá lhe dar algo em troca.");
                            System.out.println("Essa troca pode ser algo útil e vantajoso para você, ou pode ser algo aparentemente inútil ou até mesmo algo que lhe atrapalhe!");
                            System.out.println();
                            System.out.println("De qualquer forma, o Viajante é uma figura intrigante que desperta a curiosidade e o interesse das pessoas ao seu redor.");
                        } 

                        System.out.println();
                        System.out.println("O você aceita dar uma moeda para ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            int rdm = (int) ((Math.random() * 4) + 1);
                            gt.evento(rdm, pl);

                        } else if (opcao == 'n' || opcao == 'N') {
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