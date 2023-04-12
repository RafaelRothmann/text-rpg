package src.characters;

import java.io.IOException;
import java.util.Scanner;

import src.system.screen;

public class zombie {
    public static Scanner sc = new Scanner(System.in);
    protected String nome;
    protected String cenario;
    protected int vida;
    protected int ataque;
    protected int defesa;

    public zombie(double level) {
        this.cenario = "no chão";
        this.nome = "Zumbi";
        this.vida = (int) (2 * (0.3 * level));
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

    public int getDefesa() {
        return this.defesa;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public String getCenario() {
        return this.cenario;
    }

    public void stratFight(player pl) throws InterruptedException, IOException {
        boolean lutar = true;
        char opcao;
        while (lutar == true && pl.getVida() > 0) {
            boolean k = false;
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
            System.out.println("2 - Para procurar um item " + getCenario());
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
                    screen.pause();
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
                downVida(vida);
                if (getVida() <= 0) {
                    System.out.println("Você matou o " + getNome() + "!");
                    int lvl = (int) ((getVida()) / pl.getLvl());
                    if (lvl <= 0) {
                        screen.pause();
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Você ganhou " + lvl + " de nível");
                        pl.upLvl(lvl);
                        screen.pause();
                        break;
                    }
                }
                System.out.println();
                System.out.println("Vida do " + getNome() + " agora: " + getVida());
                screen.pause();
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
                screen.pause();

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
                screen.pause();

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

                screen.pause();
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
                    screen.pause();
                }
                continue;
            } else {
                continue;
            }
        }
    }

    public String toString() {
        return "\n" +
                "Os zumbis são criaturas que não pensam, apenas atacam!" +
                "\n" +
                "Eles também costumam ser uma das criaturas mais fracas!" +
                "\n" +
                "Ótimas para subir de nível!!!";
    }
}
