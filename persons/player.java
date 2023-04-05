package persons;

public class player {
    private double lvl;
    private int vida;
    private int escudo;
    private int dano;
    private int moeda;

    public player(double level){
        this.lvl = level;
        this.vida = (int) (5 * this.lvl);
        this.escudo = (int) (0.5 * this.lvl);
        this.dano = (int) (2 * (0.3 * this.lvl));
        this.moeda = 0;
    }

    public double getLvl(){
        return this.lvl;
    }

    public double downLvl(double level){ 
        return this.lvl -= level;
    }

    public double upLvl(double level){
        return this.lvl += level;
    }
    
    public int getVida(){
        return this.vida;
    }

    public int downVida(int vida){
        return this.vida -= vida;
    }

    public int upVida(int vida){
        return this.vida -= vida;
    }
}
