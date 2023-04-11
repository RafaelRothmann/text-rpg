package src.characters;

import java.io.IOException;

public class orcs extends zombie {

    public orcs(double level){
        super(level);
        this.cenario = "no chão";
        this.nome = "Orcs";
        this.vida = (int) (4.5 * (0.3 * level));
        this.ataque = (int) (5.5 * (level));
        this.defesa = (int) (0.5 * (0.5 * level));
    }

    public void lutar(player pl) throws InterruptedException, IOException{
        System.out.println("O " + getNome() + " te deu um soco!");
        System.out.println("Você perdeu 1 de vida!");
        pl.downVida(1);
        stratFight(pl);
    }

    public String toString(){
        return "\n" +
        "Os orcs são criaturas que não pensam, apenas atacam!" +
        "\n" +
        "Eles também costumam ter um ataque forte com uma defesa fraca!" +
        "\n" +
        "Você deve tentar matar-lo logo no primeiro ataque!!!";
    }
}
