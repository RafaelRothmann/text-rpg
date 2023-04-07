package characters;

import java.util.Scanner;

public class player {
    private double lvl;
    private int vida;
    private int defesa;
    private int ataque;
    private int moeda;
    private String nome;
    private Integer[] poções;

    public player(double level) {
        this.lvl = level;
        this.vida = (int) (5 * this.lvl);
        this.defesa = (int) ((0.5 * this.lvl) + 1);
        this.ataque = (int) (2 * (0.3 * this.lvl) + 1);
        this.moeda = 1;
        this.poções = new Integer[10];
    }

    public double getLvl() {
        return this.lvl;
    }

    public double downLvl(double level) {
        return this.lvl -= level;
    }

    public double upLvl(double level) {
        return this.lvl += level;
    }

    public int getVida() {
        return this.vida;
    }

    public int downVida(int vida) {
        return this.vida -= vida;
    }

    public int upVida(int vida) {
        return this.vida += vida;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int downAtaque(int ataque) {
        return this.ataque -= ataque;
    }

    public int upAtaque(int ataque) {
        return this.ataque += ataque;
    }

    public int getDefesa() {
        return this.defesa;
    }

    public int downDefesa(int defesa) {
        return this.defesa -= defesa;
    }

    public int upDefesa(int defesa) {
        return this.defesa += defesa;
    }

    public int getMoeda() {
        return this.moeda;
    }

    public int downMoeda(int moeda) {
        return this.moeda -= moeda;
    }

    public int upMoeda(int moeda) {
        return this.moeda += moeda;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPoção(Integer poção) {
        return this.poções[poção];
    }

    public String getNomePoção(int poção, boolean compl) {
        if (compl == true) {
            String p[] = { "Poção Pequena de Cura", "Poção Média de Cura", "Poção Grande de Cura",
                    "Poção Pequena de Ataque", "Poção Média de Ataque", "Poção Grande de Ataque",
                    "Poção Pequena de Defesa", "Poção Média de Defesa", "Poção Grande de Defesa",
                    "Poção Pequena de Nível" };
            return p[poção];
        } else {
            String p[] = { "Poções Pequenas de Cura", "Poções Médias de Cura", "Poções Grandes de Cura",
                    "Poções Pequenas de Ataque", "Poções Médias de Ataque", "Poções Grandes de Ataque",
                    "Poções Pequenas de Defesa", "Poções Médias de Defesa", "Poções Grandes de Defesa",
                    "Poções Pequenas de Nível" };
            return p[poção];
        }
    }

    public String getDescPoção(int poção, int i) {
        String p[] = { "2 de vida", "5 de vida", "10 de vida", "2 de ataque", "4 de ataque", "7 de ataque",
                "2 de defesa", "4 de defesa", "7 de defesa", "2 de nível" };
        String b[] = { "ganha ", "ganhou ", "perde ", "perdeu " };
        if (i == 0) {
            return b[0] + p[poção];
        } else if (i == 1) {
            return b[1] + p[poção];
        } else if (i == 2) {
            return b[2] + p[poção];
        } else {
            return b[3] + p[poção];
        }
    }

    public void usePoções(int poção, int quantidade) {
        for (int i = 1; i <= quantidade; i++) {
            if (poção == 0)
                upVida(2);
            else if (poção == 1)
                upVida(5);
            else if (poção == 2)
                upVida(10);
            else if (poção == 3)
                upAtaque(2);
            else if (poção == 4)
                upAtaque(4);
            else if (poção == 5)
                upAtaque(7);
            else if (poção == 6)
                upDefesa(2);
            else if (poção == 7)
                upDefesa(4);
            else if (poção == 8)
                upDefesa(7);
            else if (poção == 9)
                upLvl(2);
        }
    }

    public void addPoções(int poção, int quantidade) {
        if (this.poções[poção] == null) {
            this.poções[poção] = quantidade;
        } else {
            this.poções[poção] += quantidade;
        }
    }

    public void removePoções(int poção, int quantidade) {
        if (this.poções[poção] != null) {
            this.poções[poção] -= quantidade;
        }
    }

    public Integer[] getArryPoções() {
        return this.poções;
    }

    public void toUsePoções(int poção) {
        Scanner sc = new Scanner(System.in);
        char opcao;
        int bom = 9;

        System.out.print("Deseja saber mais sobre a " + getNomePoção(poção, true) + " antes de a usar (s/n)?");
        opcao = sc.next().charAt(0);

        System.out.println();
        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
            if (opcao > bom) {
                System.out.println("Com a " + getNomePoção(poção, true) + ", você " + getDescPoção(poção, 0) + " !");
            } else {
                System.out.println("Com a " + getNomePoção(poção, true) + ", você " + getDescPoção(poção, 2) + " !");
            }
            System.out.println();
        }

        System.out.print("Você tem certeza de que deseja usar uma " + getNomePoção(poção, true) + " (s/n)? ");
        opcao = sc.next().charAt(0);

        System.out.println();
        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
            if (getPoção(poção) > 1) {
                System.out.print("Quantas poções quer usar? ");
                int n = sc.nextInt();
                if (poção > bom) {
                    System.out.println("Você usou "+ n + " , " + getNomePoção(poção, true) + "!" + " Você "
                            + getDescPoção(poção, 3) + "!!!");
                    System.out.println();
                    removePoções(poção, n);
                    usePoções(poção,n);
                } else {
                    System.out.println("Você usou 1, " + getNomePoção(poção, true) + "!" + " Você "
                            + getDescPoção(poção, 1) + "!!!");
                    System.out.println();
                    removePoções(poção, 1);
                    usePoções(poção,1);
                }
            } else {
                if (poção > bom) {
                    System.out.println("Você usou 1, " + getNomePoção(poção, true) + "!" + " Você "
                            + getDescPoção(poção, 3) + "!!!");
                } else {
                    System.out.println("Você usou 1, " + getNomePoção(poção, true) + "!" + " Você "
                            + getDescPoção(poção, 1) + "!!!");
                }
                System.out.println();
                removePoções(poção, 1);
                usePoções(poção,1);
            }

        }
    }
}
