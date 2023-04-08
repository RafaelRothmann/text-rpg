package src.characters;

import java.io.IOException;
import java.util.Scanner;

import src.system.screen;

public class pilgrim {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;

    public pilgrim(double level) {
        nome = "Peregrino";
        this.vida = (int) (5 * (0.3 * level));
        this.ataque = (int) (2.5 * (level));
        this.defesa = (int) (1.5 * (0.5 * level));
    }

    public String getNome() {
        return this.nome;
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
        boolean lutar = true, i = false;
        char opcao;
        Scanner sc = new Scanner(System.in);
        int b = 0;

        while (lutar == true || pl.getVida() > 0) {
            if (getVida() < 0) {
                System.out.println("Você matou o " + getNome() + "!");
                int lvl = (int) ((0.5 * b) / pl.getLvl());
                System.out.println("Você ganhou " + lvl + " de nível");
                pl.upLvl(lvl);
                break;
            }
            boolean k = false;
            b++;
            screen.clear();
            if (i == false) {
                System.out.println("O Peregrino te deu um tapa");
                System.out.println();
                pl.downVida(1);
                System.out.println("Você perdeu " + 1 + " de vida!");
                System.out.println();
                System.out.print("Digite S para continuar... ");
                opcao = sc.next().charAt(0);
                i = true;
            }
            screen.clear();
            System.out.println("Olá, " + pl.getNome() + ", veja seus atributos: ");
            System.out.println();
            System.out.println("Nível: " + (int) (pl.getLvl()));
            System.out.println("Vida: " + pl.getVida());
            System.out.println("Ataque: " + pl.getAtaque());
            System.out.println("Defesa: " + pl.getDefesa());
            System.out.println("Moedas: " + pl.getMoeda());

            for (int j = 0; j < pl.getArryPoções().length; j++) {
                if (pl.getPoção(j) == null || pl.getPoção(j) <= 0) {
                } else {
                    k = true;
                    if (pl.getPoção(j) > 1) {
                        System.out.println(pl.getNomePoção(j, false) + ": " + pl.getPoção(j));
                    } else {
                        System.out.println(pl.getNomePoção(j, true) + ": " + pl.getPoção(j));
                    }
                }
            }

            System.out.println();
            System.out.println("--- Menu da Luta contra o " + getNome() + " ---");
            System.out.println("0 - Para fugir da luta");
            System.out.println("1 - Para atacar");
            System.out.println("2 - Para procurar um item no chão");
            if (k == true) {
                System.out.println("3 - Para usar uma poção");
            }
            System.out.print("Digite a sua opção: ");
            int jogo = sc.nextInt();

            screen.clear();

            if (jogo == 3 && k == false) {
                continue;
            }

            if (jogo == 0) {
                System.out.print("Você tem certeza de que deseja fugir (s/n)? ");
                opcao = sc.next().charAt(0);
                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    lutar = false;
                    break;
                } else if (opcao == 'n' || opcao == 'N') {
                    continue;
                } else {
                    System.out.println("Erro, reinicei o jogo :C");
                    System.out.println();
                    System.out.print("Digite S para continuar... ");
                    opcao = sc.next().charAt(0);
                    continue;
                }
            }
            if (jogo == 1) {
                int vida = pl.getAtaque() - getDefesa();

                if (vida <= 0) {
                    System.out.println("O " + getNome() + " esquivou do ataque!!");
                    vida = 0;
                } else {
                    System.out.println("Você deu um dano de " + vida + " no " + getNome());
                }
                System.out.println();
                downVida(vida);
                if (getVida() <= 0) {
                    System.out.println("Você matou o " + getNome() + "!");
                    int lvl = (int) ((getVida()) / pl.getLvl());
                    if (lvl <= 0) {
                        System.out.println();
                        System.out.print("Digite S para continuar... ");
                        opcao = sc.next().charAt(0);
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Você ganhou " + lvl + " de nível");
                        pl.upLvl(lvl);
                        System.out.println();
                        System.out.print("Digite S para continuar... ");
                        opcao = sc.next().charAt(0);
                        break;
                    }
                }
                System.out.println();
                System.out.println("Vida do " + getNome() + " agora: " + getVida());
                System.out.println();
                System.out.print("Digite S para continuar... ");
                opcao = sc.next().charAt(0);

                screen.clear();
                vida = getAtaque() - pl.getDefesa();

                if (vida <= 0) {
                    System.out.println("Você esquivou do ataque do " + getNome());
                    vida = 0;
                } else {
                    System.out.println("O " + getNome() + " te deu um dano de " + vida);
                }
                pl.downVida(vida);
                if (pl.getVida() <= 0) {
                    break;
                }
                System.out.println();
                System.out.println("Sua vida agora: " + pl.getVida());
                System.out.println();
                System.out.print("Digite S para continuar... ");
                opcao = sc.next().charAt(0);

                continue;
            }
            if (jogo == 2) {
                vida = getAtaque() - pl.getDefesa();

                if (vida <= 0) {
                    System.out.println("Você esquivou do ataque do " + getNome());
                    vida = 0;
                } else {
                    System.out.println("O " + getNome() + " te deu um dano de " + vida);
                }
                System.out.println();
                pl.downVida(vida);
                if (pl.getVida() <= 0) {
                    break;
                }

                System.out.println();
                System.out.println("Sua vida agora: " + pl.getVida());
                System.out.println();
                System.out.print("Digite S para continuar... ");
                opcao = sc.next().charAt(0);
                screen.clear();

                int rdm = (int) ((Math.random() * 3) + 1);
                if (rdm == 1) {
                    int qd = (int) ((Math.random() * 4) + 1);
                    System.out.println("Você achou " + qd + " moedas no chão!");
                    System.out.println();
                    System.out.print("Deseja pegar (s/n)? ");
                    opcao = sc.next().charAt(0);
                    System.out.println();

                    if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                        System.out.println("Você pegou " + qd + " moedas no chão!");
                        pl.upMoeda(qd);
                    }
                } else if (rdm == 2) {
                    System.out.println("Você não achou nada!");
                } else {
                    int qd = (int) ((Math.random() * 4) + 1);
                    int position = (int) ((Math.random() * 10) + 1);
                    int bom = 9;
                    boolean compl;
                    String pre;

                    if (qd > 1) {
                        compl = false;
                        pre = "as";
                    } else {
                        compl = true;
                        pre = "a";
                    }

                    System.out.println("Você achou " + qd + ", de " + pl.getNomePoção(position, compl));
                    System.out.println();
                    System.out.print("Deseja saber mais sobre a " + pl.getNomePoção(position, compl) + " (s/n)? ");
                    opcao = sc.next().charAt(0);

                    if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                        if (opcao > bom) {
                            System.out.println();
                            System.out.println("Com a " + pl.getNomePoção(position, compl) + ", você "
                                    + pl.getDescPoção(position, 0) + "!");
                        } else {
                            System.out.println();
                            System.out.println("Com a " + pl.getNomePoção(position, compl) + ", você "
                                    + pl.getDescPoção(position, 2) + "!");
                        }
                    }

                    System.out.println();
                    System.out.println("Deseja pegar " + pre + " " + pl.getNomePoção(position, compl) + "?");
                    opcao = sc.next().charAt(0);
                    if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                        System.out.println("Você pegou " + pre + " " + pl.getNomePoção(position, compl));
                        pl.addPoções(position, qd);
                    }
                }

                System.out.print("Digite S para continuar... ");
                opcao = sc.next().charAt(0);
                continue;
            } else if (jogo == 3) {
                screen.clear();

                System.out.println("Qual poção deseja usar: ");
                System.out.println();

                for (int j = 0; j < pl.getArryPoções().length; j++) {
                    if (pl.getPoção(j) == null || pl.getPoção(j) <= 0) {
                    } else {
                        if (pl.getPoção(j) > 1) {
                            System.out.println(j + " - " + pl.getNomePoção(j, false) + ": " + pl.getPoção(j));
                        } else {
                            System.out.println(j + " - " + pl.getNomePoção(j, true) + ": " + pl.getPoção(j));
                        }
                    }
                }
                System.out.println();
                System.out.print("Digite a sua opção: ");
                int poção = sc.nextInt();
                try {
                    if (pl.getArryPoções() == null || pl.getPoção(poção) == 0 || pl.getPoção(poção) == null) {
                        System.out.println("Você não tem essa poção! ");
                    } else {
                        pl.toUsePoções(poção);
                        System.out.println();
                    }
                } catch (NullPointerException e) {
                    System.out.println("Você não tem essa poção! ");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Você não tem essa poção! ");
                } finally {
                    System.out.println();
                    System.out.print("Digite S para continuar... ");
                    opcao = sc.next().charAt(0);
                }
                continue;
            } else {
                continue;
            }
        }
    }

    public void evento(int random, player pl) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
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
                        System.out.println("Digite S para continuar...");
                        op = sc.next().charAt(0);
                        luta(pl);
                    } else {
                        pl.downMoeda(rdm);
                        System.out.println("Você deu as " + rdm + " moedas!");
                        System.out.println("Digite S para continuar...");
                        op = sc.next().charAt(0);
                    }
                } else if (op2 == 'n' || op2 == 'N') {
                    System.out.println("Como assim " + pl.getNome() + "?");
                    System.out.println();
                    System.out.print("Digite S para continuar... ");
                    op = sc.next().charAt(0);
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
