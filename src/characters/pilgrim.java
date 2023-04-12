package src.characters;

import java.io.IOException;

import src.system.screen;

public class pilgrim extends zombie {

    public pilgrim(double level) {
        super(level);
        this.nome = "Peregrino";
        this.cenario = "no chão";
        this.vida = (int) (5 * (0.3 * level));
        this.ataque = (int) (2.5 * (level));
        this.defesa = (int) (1.5 * (0.5 * level));
    }

    public void luta(player pl) throws InterruptedException, IOException {

        System.out.println("O " + getNome() + " te deu um tapa!");
        System.out.println();
        System.out.println("Você perdeu 1 de vida!");
        pl.downVida(1);
        screen.pause();

        if (pl.getVida() > 0) {
            stratFight(pl);
            if (getVida() < 0) {
                System.out.println("Você matou o " + getNome() + "!");
                int lvl = (int) ((3.5 * pl.getVida()) / pl.getLvl());
                System.out.println("Você ganhou " + lvl + " de nível");
                pl.upLvl(lvl);
            }
        }
    }

    public void evento(int random, player pl) throws InterruptedException, IOException {
        char op;
        screen.clear();
        String poção = "O Peregrino te ofecereceu um gole de uma poção desconhecida, deseja tomar (s/n)? ";
        int bom = 9;
        switch (random) {
            case 1:
                int rdm = (int) ((Math.random() * (5 - (pl.getLvl())) + 1));
                System.out.println("O Peregrino te deu uma bolsa, com " + rdm + " de nível!");
                System.out.println();
                System.out.print("Você aceita essa bolsa (s/n)?");
                op = sc.next().charAt(0);
                System.out.println();
                if (op == 's' || op == 'y' || op == 'S' || op == 'Y') {
                    System.out.println("Você ganhou " + rdm + " de nível!");
                    pl.upLvl(rdm);
                }
                break;
            case 2:
                int position = (int) ((Math.random() * 10) + 1);
                position -= 1;
                rdm = (int) ((Math.random() * ((5) / pl.getLvl()) + 1));
                System.out.print(poção);
                op = sc.next().charAt(0);

                System.out.println();
                if (op == 's' || op == 'y' || op == 'S' || op == 'Y') {
                    if (position > bom) {
                        System.out.println("Você " + pl.getDescPoção(position, 3));
                    } else {
                        System.out.println("Você " + pl.getDescPoção(position, 1));
                    }
                    pl.usePoções(position, 1);

                } else if (op == 'n' || op == 'N') {
                    System.out.println("Que pena " + pl.getNome() + " !");
                }
                break;
            case 3:
                rdm = (int) ((Math.random() * (5 - (pl.getLvl())) + 1));
                System.out.println("O Peregrino te ofecereceu uma bolsa, com " + rdm + " de Moedas!");
                System.out.print("Deseja aceitar (s/n)? ");
                char op1 = sc.next().charAt(0);

                if (op1 == 's' || op1 == 'y' || op1 == 'S' || op1 == 'Y') {
                    System.out.println("Você pegou as " + rdm + " moedas!");
                    pl.upMoeda(rdm);
                }
                break;
            case 4:
                rdm = (int) ((Math.random() * ((5 + pl.getLvl()) - (pl.getMoeda())) + 1));
                System.out.println("O Peregrino está pedindo 10 moedas, deseja dar (s/n)?");
                char op2 = sc.next().charAt(0);

                System.out.println();
                if (op2 == 's' || op2 == 'y' || op2 == 'S' || op2 == 'Y') {
                    if (pl.getMoeda() < rdm) {
                        System.out.println("Cade as moedas?");
                        screen.pause();
                        luta(pl);
                    } else {
                        pl.downMoeda(rdm);
                        System.out.println("Você deu as " + rdm + " moedas!");
                        screen.pause();
                    }
                } else if (op2 == 'n' || op2 == 'N') {
                    System.out.println("Como assim " + pl.getNome() + "?");
                    screen.pause();
                    luta(pl);
                }
                break;
            default:
                System.out.println("O Peregrino pegou a moeda e foi embora... ");
                break;
        }
    }

    public String toString() {
        return "\n" +
                "O Peregrino é um misterioso personagem que percorre diferentes lugares em busca de novas aventuras e experiências."
                +
                "\n" +
                "Ele é conhecido por oferecer uma troca curiosa: se você der uma moeda a ele, o Peregrino irá lhe dar algo em troca."
                +
                "\n" +
                "Essa troca pode ser algo útil e vantajoso para você, ou pode ser algo aparentemente até mesmo algo que lhe atrapalhe!"
                +
                "\n" +
                "Os Peregrinos também costumam a ficar bravos com uma certa facilidade!" +
                "\n" +
                "De qualquer forma, o Peregrino é uma figura intrigante que desperta a curiosidade e o interesse das pessoas ao seu redor.";
    }

}
