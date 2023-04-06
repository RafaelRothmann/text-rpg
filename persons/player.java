package persons;

public class player {
    private double lvl;
    private int vida;
    private int defesa;
    private int ataque;
    private int moeda;
    private String nome;

    public player(double level){
        this.lvl = level;
        this.vida = (int) (5 * this.lvl);
        this.defesa = (int) ((0.5 * this.lvl) + 1);
        this.ataque = (int) (2 * (0.3 * this.lvl) + 1);
        this.moeda = 1;
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
        return this.vida += vida;
    }

    public int getAtaque(){
        return this.ataque;
    }

    public int downAtaque(int ataque){ 
        return this.ataque -= ataque;
    }

    public int upAtaque(int ataque){
        return this.ataque += ataque;
    }

    public int getDefesa(){
        return this.defesa;
    }

    public int downDefesa(int defesa){ 
        return this.defesa -= defesa;
    }

    public int upDefesa(int defesa){
        return this.defesa += defesa;
    }

    public int getMoeda(){
        return this.moeda;
    }

    public int downMoeda(int moeda){
        return this.moeda -= moeda;
    }

    public int upMoeda(int moeda){
        return this.moeda += moeda;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
