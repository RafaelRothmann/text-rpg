package src.system;

import java.io.IOException;
import java.util.Scanner;

import src.characters.pilgrim;
import src.characters.player;
import src.characters.zombie;
import src.characters.goblin;

public class game {
    private int Level;

    public game(int lvl) {
        this.Level = lvl;
    }

    public void gameMode() throws InterruptedException, IOException {
        screen.clear();

        try (Scanner sc = new Scanner(System.in)) {
            player pl = new player(this.Level);
            int rdm, jogo;
            boolean janela = true;
            char opcao;
            String op = null;

            pl.upMoeda(10000);
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
                    System.out.println();
                    System.out.print("Digite S para continuar... ");
                    op = sc.nextLine();
                    break;
                }

                if (op == null) {
                    System.out.println("Seja Bem-vindo ao rpg de texto!");
                    System.out.println();
                    System.out.print("Escreva um nome: ");
                    String nome = sc.nextLine();
                    pl.setNome(nome);
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
                System.out.println("---Menu---");
                System.out.println("0 - Para sair");
                System.out.println("1 - Para sortear");
                System.out.println("2 - Para entrar na Loja");
                if (k == true) {
                    System.out.println("3 - Para usar uma poção");
                }
                System.out.print("Digite a sua opção: ");
                jogo = sc.nextInt();
                int random = (int) ((Math.random() * 3) + 1);

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
                        System.out.print("Digite S para continuar... ");
                        op = sc.nextLine();
                        continue;
                    } else {
                        System.out.println("Erro, reinicei o jogo :C");
                        System.out.print("Digite S para continuar... ");
                        op = sc.nextLine();
                        break;
                    }

                } else if (jogo == 1) {
                    screen.clear();
                    switch (random) {
                        case 1:
                            pilgrim pm = new pilgrim(pl.getLvl());
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

                            System.out.print("Digite S para continuar... ");
                            op = sc.nextLine();

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

                            System.out.print("Digite S para continuar... ");
                            op = sc.nextLine();

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

                            System.out.print("Digite S para continuar... ");
                            op = sc.nextLine();

                            continue;
                        case 4:
                            zombie zm = new zombie(pl.getLvl());
                            System.out.println("Apareceu um " + zm.getNome() + "!");
                            System.out.println();
                            System.out.print("Quer saber mais sobre ele (s/n)? ");
                            opcao = sc.next().charAt(0);

                            if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                                System.out.println(zm);
                            }

                            System.out.println();
                            System.out.print("Digite S para continuar... ");
                            op = sc.nextLine();

                            screen.clear();
                            System.out.println("O " + zm.getNome() + " te deu um tapa!");
                            System.out.println();
                            System.out.println("Você perdeu 1 de vida!");
                            pl.downMoeda(1);
                            System.out.println();
                            System.out.print("Digite S para continuar... ");
                            op = sc.nextLine();
                            
                            zm.stratFight(pl);
                            continue;
                        default:
                            System.out.println("Erro, reinicei o jogo :C");
                            System.out.print("Digite S para continuar... ");
                            op = sc.nextLine();
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
                        System.out.println();
                        System.out.print("Digite S para continuar... ");
                        op = sc.nextLine();
                    }
                    continue;
                } else if (jogo == 2) {
                    screen.clear();
                    goblin gb = new goblin(pl.getLvl());
                    System.out.println("Seja Bem-Vindo a Loja do " + gb.getNome());
                    System.out.print("Quer saber mais sobre a loja (s/n)? ");
                    opcao = sc.next().charAt(0);

                    if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                        screen.clear();
                        System.out.println(gb);
                        System.out.println();
                        System.out.print("Digite S para continuar... ");
                        opcao = sc.next().charAt(0);
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
}
