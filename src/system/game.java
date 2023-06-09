package src.system;

import java.io.IOException;
import java.util.Scanner;

import src.characters.pilgrim;
import src.characters.player;
import src.characters.zombie;
import src.characters.goblin;
import src.characters.orcs;

public class game {
    public static Scanner sc = new Scanner(System.in);
    private double Level;

    public game(int lvl) {
        this.Level = lvl;
    }

    public double getLevel() {
        return this.Level;
    }

    public void autoLevel() {
        this.Level += 0.01;
    }

    public String getDica() {
        String dica[] = { "Os zumbis são ótimas criaturas para subir de nível!",
                "Os peregrinos ficam iritados se você recusa um pedido deles!",
                "Após uma tentativa de roubo na Loja do Globin, o Globin ficará com raiva de você!",
                "Quanto maior o seu nível mais caro ficará os itens da loja do Globin!",
                "Os orcs são criaturas com pouca defesa, mas com ataque forte!" };
        int rdm = (int) (((Math.random() * 5) + 1) - 1);
        return dica[rdm];
    }

    public void gameMode() throws InterruptedException, IOException {
        screen.clear();
        player pl = new player(getLevel());
        int rdm;
        boolean janela = true;
        char opcao;
        Integer sr1 = null;
        int random;

        while (janela == true) {
            boolean k = false;
            if (pl.getVida() <= 0) {
                screen.clear();
                System.out.println("Você morreu!!!");
                System.out.println("veja suas estatisticas finais:");
                System.out.println();
                System.out.println("Nível: " + (int) (pl.getLvl()));
                System.out.println("Ataque: " + pl.getAtaque());
                System.out.println("Defesa: " + pl.getDefesa());
                System.out.println("Moedas: " + pl.getMoeda());
                for (int j = 0; j < pl.getArryPoções().length; j++) {
                    if (pl.getPoção(j) == null || pl.getPoção(j) <= 0) {
                    } else {
                        if (pl.getPoção(j) > 1) {
                            System.out.println(pl.getNomePoção(j, false) + ": " + pl.getPoção(j));
                        } else {
                            System.out.println(pl.getNomePoção(j, true) + ": " + pl.getPoção(j));
                        }
                    }
                }
                screen.pause();
                break;
            }

            if (sr1 == null) {
                System.out.println("Seja Bem-vindo ao rpg de texto!");
                System.out.println();
                System.out.print("Escreva um nome: ");
                String nome = sc.nextLine();
                pl.setNome(nome);
                sr1 = 1;
            } else {
                autoLevel();
            }

            screen.clear();
            System.out.println("Dica: " + getDica());
            System.out.println();
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
            System.out.println("--- Menu ---");
            System.out.println("0 - Para sair");
            System.out.println("1 - Para sortear");
            System.out.println("2 - Para entrar na Loja");
            if (k == true) {
                System.out.println("3 - Para usar uma poção");
            }
            System.out.print("Digite a sua opção: ");

            int jogo = sc.nextInt();

            if (pl.getLvl() >= 5) {
                random = (int) ((Math.random() * 5) + 1);
            } else {
                random = (int) ((Math.random() * 4) + 1);
            }

            if (k == false && jogo == 3) {
                continue;
            }

            if (jogo == 0) {
                System.out.print("Você tem certeza (s/n)? ");
                opcao = sc.next().charAt(0);

                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    janela = false;
                    break;
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Obrigado!");
                    screen.pause();
                    continue;
                } else {
                    System.out.println("Erro, reinicei o jogo :C");
                    screen.pause();
                    break;
                }

            } else if (jogo == 1) {
                screen.clear();
                switch (random) {
                    case 1:
                        pilgrim pm = new pilgrim(getLevel());
                        System.out.println("Apareceu um " + pm.getNome() + " !");
                        System.out.print("Quer saber mais sobre ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println(pm);
                        }

                        System.out.println();
                        System.out.print("O você aceita dar uma moeda para ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            if (pl.getMoeda() < 1) {
                                System.out.println("Mas cade as moedas??");
                            } else {
                                System.out.println("Você perdeu " + 1 + " moeda");
                                pl.downMoeda(1);
                                rdm = (int) ((Math.random() * 5) + 1);
                                pm.evento(rdm, pl);
                            }
                        } else if (opcao == 'n' || opcao == 'N') {
                            System.out.println("Esperava mais de você, " + pl.getNome() + " !");
                        }

                        screen.pause();
                        continue;
                    case 2:
                        int rdm1 = (int) ((Math.random() * 9) + 1);
                        rdm = (int) ((Math.random() * 3) + 1);

                        if (rdm > 1) {
                            System.out.print("Você achou " + rdm + ", " + pl.getNomePoção(rdm1, false)
                                    + " no chão, deseja pegar (s/n)? ");
                        } else {
                            System.out.print("Você achou " + rdm + ", " + pl.getNomePoção(rdm1, true)
                                    + " no chão, deseja pegar (s/n)? ");
                        }
                        opcao = sc.next().charAt(0);

                        System.out.println();
                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            if (rdm > 1) {
                                System.out.println("Você pegou as " + rdm + ", " + pl.getNomePoção(rdm1, false));
                            } else {
                                System.out.println("Você pegou as " + rdm + ", " + pl.getNomePoção(rdm1, true));
                            }
                            pl.addPoções(rdm1, rdm);
                        }

                        screen.pause();

                        continue;
                    case 3:
                        rdm = (int) ((Math.random() * 9) + 1);
                        System.out.print("Você achou " + rdm + " moedas no chão, deseja pegar (s/n)? ");
                        opcao = sc.next().charAt(0);

                        System.out.println();
                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println("Você pegou as " + rdm + " moedas");
                            pl.upMoeda(rdm);
                        }

                        screen.pause();

                        continue;
                    case 4:
                        zombie zm = new zombie(getLevel());
                        System.out.println("Apareceu um " + zm.getNome() + "!");
                        System.out.println();
                        System.out.print("Quer saber mais sobre ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println(zm);
                        }

                        screen.pause();

                        System.out.println("O " + zm.getNome() + " te deu um tapa!");
                        System.out.println();
                        System.out.println("Você perdeu 1 de vida!");
                        pl.downMoeda(1);
                        screen.pause();

                        zm.stratFight(pl);
                        continue;
                    case 5:
                        orcs ors = new orcs(getLevel());
                        System.out.println("Apareceu um " + ors.getNome() + "!");
                        System.out.println();
                        System.out.print("Quer saber mais sobre ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println(ors);
                        }

                        screen.pause();

                        ors.lutar(pl);
                        continue;
                    default:
                        System.out.println("Erro, reinicei o jogo :C");
                        screen.pause();
                        break;
                }
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
                    screen.pause();
                }
                continue;
            } else if (jogo == 2) {
                screen.clear();
                goblin gb = new goblin(getLevel());
                System.out.println("Seja Bem-Vindo a Loja do " + gb.getNome());
                System.out.print("Quer saber mais sobre a loja (s/n)? ");
                opcao = sc.next().charAt(0);

                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    screen.clear();
                    System.out.println(gb);
                    screen.pause();
                    gb.loja(pl);
                } else {
                    gb.loja(pl);
                }
                continue;
            } else {
                continue;
            }
        }
    }
}
