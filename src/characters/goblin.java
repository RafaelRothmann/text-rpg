package src.characters;

import java.io.IOException;
import java.lang.Math;


import src.system.screen;

public class goblin extends zombie {
    private double level;
    private boolean heIsAngry = false;
    private boolean isVisit;

    public goblin(double level) {
        super(level);
        this.level = level;
        this.vida = (int) (20 * level);
        this.ataque = (int) (15 * level);
        this.defesa = (int) (10 * level);
        this.cenario = "na loja";
        this.nome = "Goblin";
        this.isVisit = false;
    }

    public boolean getIsAngry() {
        return this.heIsAngry;
    }

    public double getLvl() {
        return this.level;
    }

    public void loja(player pl) throws InterruptedException, IOException {
        screen.clear();

        if (this.isVisit == true && this.heIsAngry == true) {
            System.out.println("A loja está fechada...");
            screen.pause();

        } else {
            char opcao;
            int item = 3;
            int p[] = new int[item];

            for (int j = 0; j < item; j++) {
                p[j] = (int) ((Math.random() * 3) + 1);
            }
            int position[] = new int[3], qd[] = new int[3], preço[] = new int[3], bom = 9;
            String nomeP[] = new String[3], descP[] = new String[3], pro[] = new String[3], pre, r;
            boolean isPosion = false, compl;

            switch (p[0]) {
                case 1:
                    qd[0] = (int) ((Math.random() * 5) + 1);
                    preço[0] = (int) ((qd[0] * pl.getLvl()) + 2);
                    if (qd[0] > 1) {
                        nomeP[0] = "Moedas";
                    } else {
                        nomeP[0] = "Moeda";
                    }
                    pro[0] = qd[0] + " " + nomeP[0] + " por " + preço[0] + " " + nomeP[0];
                    break;
                case 2:
                    qd[0] = (int) ((Math.random() * 3) + 1);
                    position[0] = (int) ((Math.random() * 10) + 1);
                    preço[0] = (int) (9.3 * pl.getLvl()) + 5;
                    isPosion = true;

                    if (qd[0] > 1) {
                        compl = false;
                        pre = "as";
                        r = "Moedas";
                    } else {
                        compl = true;
                        pre = "a";
                        r = "Moeda";
                    }
                    nomeP[0] = pl.getNomePoção(position[0], compl);
                    if (position[0] > bom) {
                        descP[0] = "Com a " + pl.getNomePoção(position[0], compl) + ", você "
                                + pl.getDescPoção(position[0], 2)
                                + "!";
                    } else {
                        descP[0] = "Com a " + pl.getNomePoção(position[0], compl) + ", você "
                                + pl.getDescPoção(position[0], 0)
                                + "!";
                    }
                    pro[0] = qd[0] + " " + nomeP[0] + " por " + preço[0] + " " + r;
                    break;
                default:
                    pro[0] = "Sem estoque!";
                    break;
            }

            switch (p[1]) {
                case 1:
                    qd[1] = (int) ((Math.random() * 5) + 1);
                    preço[1] = (int) ((qd[1] * pl.getLvl()) + 2);
                    if (qd[1] > 1) {
                        nomeP[1] = "Moedas";
                    } else {
                        nomeP[1] = "Moeda";
                    }
                    pro[1] = qd[1] + " " + nomeP[1] + " por " + preço[1] + " " + nomeP[1];
                    break;
                case 2:
                    qd[1] = (int) ((Math.random() * 4) + 1);
                    position[1] = (int) ((Math.random() * 10) + 1);
                    preço[1] = (int) (9.1 * pl.getLvl()) + 5;
                    isPosion = true;

                    if (qd[1] > 1) {
                        compl = false;
                        pre = "as";
                        r = "Moedas";
                    } else {
                        compl = true;
                        pre = "a";
                        r = "Moeda";
                    }
                    nomeP[1] = pl.getNomePoção(position[1], compl);
                    if (position[1] > bom) {
                        descP[1] = "Com " + pre + " " + pl.getNomePoção(position[1], compl) + ", você "
                                + pl.getDescPoção(position[1], 2)
                                + "!";
                    } else {
                        descP[1] = "Com " + pre + " " + pl.getNomePoção(position[1], compl) + ", você "
                                + pl.getDescPoção(position[1], 0)
                                + "!";
                    }
                    pro[1] = qd[1] + " " + nomeP[1] + " por " + preço[1] + " " + r;
                    break;
                default:
                    pro[1] = "Sem estoque!";
                    break;
            }

            switch (p[2]) {
                case 1:
                    qd[2] = (int) ((Math.random() * 5) + 1);
                    preço[2] = (int) ((qd[2] * pl.getLvl()) + 2);
                    if (qd[2] > 1) {
                        nomeP[2] = "Moedas";
                    } else {
                        nomeP[2] = "Moeda";
                    }
                    pro[2] = qd[2] + " " + nomeP[2] + " por " + preço[2] + " " + nomeP[2];
                    break;
                case 2:
                    qd[2] = (int) ((Math.random() * 4) + 1);
                    position[2] = (int) ((Math.random() * 10) + 1);
                    preço[2] = (int) (9.5 * pl.getLvl()) + 5;
                    isPosion = true;

                    if (qd[2] > 1) {
                        compl = false;
                        pre = "as";
                        r = "Moedas";
                    } else {
                        compl = true;
                        pre = "a";
                        r = "Moeda";
                    }
                    nomeP[2] = pl.getNomePoção(position[2], compl);
                    if (position[2] > bom) {
                        descP[2] = "Com " + pre + " " + pl.getNomePoção(position[2], compl) + ", você "
                                + pl.getDescPoção(position[2], 2)
                                + "!";
                    } else {
                        descP[2] = "Com a " + pl.getNomePoção(position[2], compl) + ", você "
                                + pl.getDescPoção(position[2], 0)
                                + "!";
                    }
                    pro[2] = qd[2] + " " + nomeP[2] + " por " + preço[2] + " " + r;
                    break;
                default:
                    pro[2] = "Sem estoque!";
                    break;
            }
            boolean loja = true;
            while (loja == true && this.heIsAngry == false) {
                screen.clear();
                System.out.println("---- Loja do " + getNome() + " ----");
                System.out.println();
                System.out.println("Produto 1: ");
                System.out.println(pro[0]);

                System.out.println();
                System.out.println("Produto 2: ");
                System.out.println(pro[1]);

                System.out.println();
                System.out.println("Produto 3: ");
                System.out.println(pro[2]);

                System.out.println();
                System.out.println("1 - Para o produto 1");
                System.out.println("2 - Para o produto 2");
                System.out.println("3 - Para o produto 3");
                System.out.println("4 - Para roubar");
                System.out.println("5 - Para sair");
                System.out.println();
                System.out.print("Digite a opção: ");
                int op = sc.nextInt();

                if (isPosion == true) {
                    System.out.println();
                    if (descP[0] != null && op == 1) {
                        System.out.print("Deseja saber mais sobre a " + nomeP[0] + "?");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println();
                            System.out.println(descP[0]);
                        }
                    } else if (descP[1] != null && op == 2) {
                        System.out.print("Deseja saber mais sobre a " + nomeP[1] + "?");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println();
                            System.out.println(descP[1]);
                        }
                    } else if (descP[2] != null && op == 3) {
                        System.out.print("Deseja saber mais sobre a " + nomeP[2] + "?");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println();
                            System.out.println(descP[2]);
                        }
                    }
                }
                System.out.println();

                if (op == 1) {
                    if (p[0] == 1) {
                        if (pl.getMoeda() >= preço[0]) {
                            if (preço[0] > 1) {
                                System.out.print("Tem certeza de que deseja comprar esse produto (s/n)? ");
                                char escol = sc.next().charAt(0);

                                if (escol == 's' || escol == 'y' || escol == 'S' || escol == 'Y') {
                                    System.out.println("Você gastou " + preço[0] + " de moeda!");
                                    System.out.println("Por " + qd[0] + ", " + nomeP[0] + "!");
                                    pl.downMoeda(preço[0]);
                                    pl.upMoeda(qd[0]);
                                    screen.pause();
                                    loja = false;
                                }
                            }
                        } else {
                            System.out.println("Você não tem moedas suficientes!");
                        }
                    } else if (p[0] == 2) {
                        if (pl.getMoeda() >= preço[0]) {
                            if (preço[0] > 1) {
                                System.out.print("Tem certeza de que deseja comprar esse produto (s/n)? ");
                                char ecol = sc.next().charAt(0);

                                if (ecol == 's' || ecol == 'y' || ecol == 'S' || ecol == 'Y') {
                                    System.out.println("Você gastou " + preço[0] + " de moeda!");
                                    System.out.println("Por " + qd[0] + ", " + nomeP[0] + "!");
                                    pl.downMoeda(preço[0]);
                                    pl.addPoções(position[0], qd[0]);
                                    screen.pause();
                                    loja = false;
                                }
                            }
                        } else {
                            System.out.println("Você não tem moedas suficientes!");
                        }
                    } else {
                        System.out.println("Sem produto!");
                    }
                } else if (op == 2) {
                    if (p[1] == 1) {
                        if (pl.getMoeda() >= preço[1]) {
                            if (preço[1] > 1) {
                                System.out.print("Tem certeza de que deseja comprar esse produto (s/n)? ");
                                char esco = sc.next().charAt(0);
                                if (esco == 's' || esco == 'y' || esco == 'S' || esco == 'Y') {
                                    System.out.println("Você gastou " + preço[1] + " de moeda!");
                                    System.out.println("Por " + qd[1] + ", " + nomeP[1] + "!");
                                    pl.downMoeda(preço[1]);
                                    pl.upMoeda(qd[1]);
                                    screen.pause();
                                    loja = false;
                                }
                            }
                        } else {
                            System.out.println("Você não tem moedas suficientes!");
                        }
                    } else if (p[1] == 2) {
                        if (pl.getMoeda() >= preço[1]) {
                            if (preço[1] > 1) {
                                System.out.print("Tem certeza de que deseja comprar esse produto (s/n)? ");
                                char scol = sc.next().charAt(0);
                                if (scol == 's' || scol == 'y' || scol == 'S' || scol == 'Y') {
                                    System.out.println("Você gastou " + preço[1] + " de moeda!");
                                    System.out.println("Por " + qd[1] + ", " + nomeP[1] + "!");
                                    pl.downMoeda(preço[1]);
                                    pl.addPoções(position[1], qd[1]);
                                    screen.pause();
                                    loja = false;
                                }
                            }
                        } else {
                            System.out.println("Você não tem moedas suficientes!");
                        }
                    } else {
                        System.out.println("Sem produto!");
                    }
                } else if (op == 3) {
                    if (p[2] == 1) {
                        if (pl.getMoeda() >= preço[2]) {
                            if (preço[2] > 1) {
                                System.out.print("Tem certeza de que deseja comprar esse produto (s/n)? ");
                                char esol = sc.next().charAt(0);
                                if (esol == 's' || esol == 'y' || esol == 'S' || esol == 'Y') {
                                    System.out.println("Você gastou " + preço[2] + " de moeda!");
                                    System.out.println("Por " + qd[2] + ", " + nomeP[2] + "!");
                                    pl.downMoeda(preço[2]);
                                    pl.upMoeda(qd[2]);
                                    screen.pause();
                                    loja = false;
                                }
                            }
                        } else {
                            System.out.println("Você não tem moedas suficientes!");
                        }
                    } else if (p[2] == 2) {
                        if (pl.getMoeda() >= preço[0]) {
                            if (preço[2] > 1) {
                                System.out.print("Tem certeza de que deseja comprar esse produto (s/n)? ");
                                char escl = sc.next().charAt(0);
                                if (escl == 's' || escl == 'y' || escl == 'S' || escl == 'Y') {
                                    System.out.println("Você gastou " + preço[2] + " de moeda!");
                                    System.out.println("Por " + qd[2] + ", " + nomeP[2] + "!");
                                    pl.downMoeda(preço[2]);
                                    pl.addPoções(position[2], qd[2]);
                                    screen.pause();
                                    loja = false;
                                }
                            }
                        } else {
                            System.out.println("Você não tem moedas suficientes!");
                        }
                    } else {
                        System.out.println("Sem produto!");
                    }
                } else if (op == 4) {
                    System.out.println();
                    System.out.println("Escolha um produto para roubar (1,2,3)? ");
                    int prod = sc.nextInt();
                    prod -= 1;

                    while (pro[prod] == "Sem estoque!") {
                        System.out.println("Não existe esse produto!");
                        System.out.println("Escolha outro!");
                        screen.pause();

                        System.out.println();
                        System.out.println("Produto 1: ");
                        System.out.println(pro[0]);

                        System.out.println();
                        System.out.println("Produto 2: ");
                        System.out.println(pro[1]);

                        System.out.println();
                        System.out.println("Produto 3: ");
                        System.out.println(pro[2]);
                        System.out.print("Digite o Produto: ");
                        prod = sc.nextInt();
                        prod -= 1;
                    }

                    System.out.println();
                    System.out.print("Tem certeza de que deseja fazer isso (s/n)? ");
                    opcao = sc.next().charAt(0);

                    if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                        startRoubed(qd[prod], nomeP[prod], position[prod], p[prod], pl);
                        loja = false;
                        break;
                    }

                } else if (op == 5) {
                    screen.clear();
                    System.out.println("Obrigado por visitar a loja do" + getNome());
                    screen.pause();
                    loja = false;
                    break;
                }
            }

        }
    }

    public void startRoubed(int qd, String nomeP, int position, int p, player pl)
            throws InterruptedException, IOException {
        this.heIsAngry = true;

        System.out.println(getNome() + " - Você realmente está tentando roubar esse produto?");
        System.out.println();
        System.out.println("O " + getNome() + " Te deu um tapa e você perdeu 2 e vida!");
        pl.downVida(2);
        screen.pause();
        stratFight(pl);

        if (getVida() <= 0) {
            System.out.println("Você matou o " + getNome() + "!");
            int lvl = (int) ((1.5 * pl.getVida()) / pl.getLvl() + 5);
            System.out.println("Você ganhou " + lvl + " de nível");
            pl.upLvl(lvl);
            if (p == 1) {
                if (qd > 1) {
                    System.out.println("Você roubou as " + nomeP);
                    pl.upMoeda(qd);
                } else {
                    System.out.println("Você roubou a " + nomeP);
                    pl.upMoeda(qd);
                }
            } else if (p == 2) {
                if (qd > 1) {
                    System.out.println("Você roubou as " + nomeP);
                    pl.addPoções(position, qd);
                } else {
                    System.out.println("Você roubou as " + nomeP);
                    pl.addPoções(position, qd);
                }
            }
            screen.pause();
        }
    }

    public String toString() {
        return "\n" +
                "Na loja do Globin, os itens são escolhidos aletóriamente a cada vez que você entra na loja." +
                "\n" +
                "E os preços são colocados conforme a qualidade do item e do nível atual do jogador," +
                "\n" +
                "Mas se tentar roubar a loja, o Globin se tornará vingativo";
    }
}
