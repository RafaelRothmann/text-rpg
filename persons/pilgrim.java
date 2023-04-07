package persons;

import java.io.IOException;
import java.util.Scanner;

import system.screen;

public class pilgrim {
    private int vida;
    private int ataque;
    private int defesa;

    public pilgrim(double level) {
        this.vida = (int) (5 * (0.3 * level));
        this.ataque = (int) (2.5 * (0.2 * level));
        this.defesa = (int) (1 * (0.1 * level));
    }

    public int getVida() {
        return this.vida;
    }

    public int downVida(int vida) {
        return this.vida -= vida;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getDefesa() {
        return this.defesa;
    }

    public void luta(player pl) throws InterruptedException, IOException {
        boolean lutar = true;
        int i = 0;
        char opcao;
        Scanner sc = new Scanner(System.in);
        while (lutar == true || pl.getVida() > 0){
            screen.clear();
            if (i == 0){
                System.out.println("O Peregrino te deu um tapa");
                pl.downVida(1);
                System.out.println("Você perdeu " + 1 + " de vida!");
                System.out.println("Digite S para continuar...");
                opcao = sc.next().charAt(0);
            } 
            i = 1;
            screen.clear();
            System.out.println("Olá, " + pl.getNome() + ", veja seus atributos: ");
            System.out.println();
            System.out.println("Nível: " + (int) (pl.getLvl()));
            System.out.println("Vida: " + pl.getVida());
            System.out.println("Ataque: " + pl.getAtaque());
            System.out.println("Defesa: " + pl.getDefesa());
            System.out.println("Moedas: " + pl.getMoeda());
            
            for (int j = 0; j < pl.getArryPoções().length; j++){
                if (pl.getPoção(j) != null){
                    System.out.println(pl.getNomePoção(j,true) + ": " + pl.getPoção(j));
                } 
            }

            System.out.println();
            System.out.println("---Menu---");
            System.out.println("0 - Para fugir da luta");
            System.out.println("1 - Para atacar");
            System.out.println("3 - Para usar uma poção");
            System.out.print("Digite a sua opção: ");
            int jogo = sc.nextInt();

            sc.close();
        }
    }

    public void evento(int random, player pl) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        char opcao;
        screen.clear();
        String poção = "O Peregrino te ofecereceu um gole de uma poção desconhecida, deseja tomar (s/n)?";
        switch (random) {
            case 1:
                int rdm = (int) ((Math.random() * (5 - (pl.getLvl())) + 1));
                System.out.println("O Peregrino te deu uma bolsa, com " + rdm + " de nível!");
                pl.upLvl(rdm);
                break;
            case 2:
                rdm = (int) ((Math.random() * ((5 - pl.getLvl()) / pl.getVida()) + 1));
                System.out.println(poção);
                opcao = sc.next().charAt(0);

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
                System.out.println(poção);
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
                System.out.println(poção);
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
                System.out.println(poção);
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
                System.out.println(poção);
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
                System.out.println(poção);
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
                System.out.println("O Peregrino te ofecereceu um gole de uma bolsa, com " + rdm + " de Moedas!");
                pl.upMoeda(rdm);
                break;
            case 9:
                rdm = (int) ((Math.random() * ((5 + pl.getLvl())- (pl.getMoeda())) + 1));
                System.out.println("O Peregrino está pedindo mais 10 moedas, deseja dar (s/n)?");
                opcao = sc.next().charAt(0);

                System.out.println();
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    if (pl.getMoeda() < rdm){
                        System.out.println("Cade as moedas?");
                        System.out.println("Digite S para continuar...");
                        opcao = sc.next().charAt(0);
                        luta(pl);
                    } else{
                        pl.downMoeda(rdm);
                        System.out.println("Você deu as " + rdm + " moedas!");
                        System.out.println("Digite S para continuar...");
                        opcao = sc.next().charAt(0);
                    }
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Como assim " + pl.getNome() + " ?");
                    System.out.println("Digite S para continuar...");
                    opcao = sc.next().charAt(0);
                    luta(pl);
                }
                break;
            default:
                System.out.println("O Peregrino pegou a moeda e foi embora... ");
                break;
        }
        sc.close();
    }

}
