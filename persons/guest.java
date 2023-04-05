package persons;
import persons.player;

public class guest {
    private int vida;
    private int dano;
    private int escudo;

    public guest(double level){
        this.vida = (int) (5 * ( 0.3 * level));
        this.dano = (int) (2.5 * (0.2 * level));
        this.escudo = (int) (1 * (0.1 * level));
    }

    public void evento(int random, player pl){
        switch (random){
            case 1:
                pl.upLvl(10);
            break;
            default:

            break;
        }
    }

    public String toString(){
        return "O Viajante é um misterioso personagem que percorre diferentes lugares em busca de novas aventuras e experiências." 
        + " " +
        " Ele é conhecido por oferecer uma troca curiosa: se você der uma moeda a ele, o Viajante irá lhe dar algo em troca." 
        + " " + 
        " Essa troca pode ser algo útil e vantajoso para você, ou pode ser algo aparentemente inútil ou até mesmo algo que lhe atrapalhe!." 
        + " " +
        " De qualquer forma, o Viajante é uma figura intrigante que desperta a curiosidade e o interesse das pessoas ao seu redor.";
    }
}
