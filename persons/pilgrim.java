package persons;

import java.util.Scanner;

public class pilgrim {
    private int vida;
    private int dano;
    private int escudo;

    public pilgrim(double level) {
        this.vida = (int) (5 * (0.3 * level));
        this.dano = (int) (2.5 * (0.2 * level));
        this.escudo = (int) (1 * (0.1 * level));
    }

    public void evento(int random, player pl) {
        Scanner sc = new Scanner(System.in);
        switch (random) {
            case 1:
                int rdm = (int) ((Math.random() * (5 - (pl.getLvl())) + 1));
                System.out.println("O Peregrino te deu uma bolsa, com " + rdm + " de XP!");
                pl.upLvl(rdm);
                break;
            case 2:
                rdm = (int) ((Math.random() * ((5 - pl.getLvl()) / pl.getVida()) + 1));
                System.out.println("O Peregrino te de uma poção desconhecida, deseja tomar (s/n)? ");
                char opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    System.out.println("Você acabou perdendo " + rdm + " de vida!");
                    pl.downVida(rdm);
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 3:
                rdm = (int) ((Math.random() * (5 + (0.2 * pl.getVida())) + 1));
                System.out.println("O Peregrino te de uma poção desconhecida, deseja tomar (s/n)? ");
                opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    System.out.println("Você acabou ganhando " + rdm + " de vida!");
                    pl.upVida(rdm);
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 4:
                rdm = (int) ((Math.random() * (5 + (0.2 * pl.getAtaque()) + 1)));
                System.out.println("O Peregrino te de uma poção desconhecida, deseja tomar (s/n)? ");
                opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    System.out.println("Você acabou ganhando " + rdm + " de ataque!");
                    pl.upAtaque(rdm);
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 5:
                rdm = (int) ((Math.random() * ((5 - pl.getLvl()) / pl.getAtaque()) + 1));
                System.out.println("O Peregrino te deu uma poção desconhecida, deseja tomar (s/n)? ");
                opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    System.out.println("Você acabou perdendo " + rdm + " de ataque!");
                    pl.downAtaque(rdm);
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 6:
                rdm = (int) ((Math.random() * (5 + (0.2 * pl.getDefesa()) + 1)));
                System.out.println("O Peregrino te deu uma poção desconhecida, deseja tomar (s/n)? ");
                opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    System.out.println("Você acabou ganhando " + rdm + " de defesa!");
                    pl.upDefesa(rdm);
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 7:
                rdm = (int) ((Math.random() * ((5 - pl.getLvl()) / pl.getDefesa()) + 1));
                System.out.println("O Peregrino te deu uma poção desconhecida, deseja tomar (s/n)? ");
                opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    System.out.println("Você acabou perdendo " + rdm + " de defesa!");
                    pl.downDefesa(rdm);
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 8:
                rdm = (int) ((Math.random() * (5 - (pl.getMoeda())) + 1));
                System.out.println("O Peregrino te deu uma bolsa, com " + rdm + " de Moedas!");
                pl.upMoeda(rdm);
            default:
                System.out.println("O Peregrino pegou a moeda e foi embora... ");
                break;
        }
    }

}
