import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import persons.player;
import persons.pilgrim;

public class Program {
    public static void main(String args[]) throws InterruptedException, IOException {
        clear();
        Scanner sc = new Scanner(System.in);
        player pl = new player(1);
        char a;
        int i = 0, rdm;
        boolean janela = true;
        char opcao;

        while (janela == true) {
            if (i == 1) {
                if (pl.getVida() <= 0){
                    System.out.println("Você morreu");
                }
                clear();
                System.out.println("Olá, " + pl.getNome() + ", veja seus atributos: ");
                System.out.println();
                System.out.println("Nível: " + (int) (pl.getLvl()));
                System.out.println("Vida: " + pl.getVida());
                System.out.println("Ataque: " + pl.getAtaque());
                System.out.println("Defesa: " + pl.getDefesa());
                System.out.println("Moedas: " + pl.getMoeda());
            } else if (i == 0) {
                System.out.println("Seja Bem-vindo ao rpg de texto!");
                System.out.println();
                System.out.print("Escreva um nome: ");
                String nome = sc.nextLine();
                pl.setNome(nome);
                i = 1;
            }
            
            System.out.println();
            System.out.println("---Menu---");
            System.out.println("0 - Para sair");
            System.out.println("1 - Para sortear");
            System.out.print("Digite a sua opção: ");
            int jogo = sc.nextInt();
            int random = (int) ((Math.random() * 1) + 1);

            if (jogo == 0) {
                System.out.print("Você tem certeza (s/n)? ");
                opcao = sc.next().charAt(0);

                if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                    janela = false;
                    break;
                } else if (opcao == 'n' || opcao == 'N') {
                    System.out.println("Obrigado!");
                    System.out.print("Digite S para continuar...");
                    a = sc.next().charAt(0);
                    continue;
                } else {
                    System.out.println("Erro, reinicei o jogo :C");
                    System.out.println("Digite S para continuar...");
                    a = sc.next().charAt(0);
                    break;
                }

            } else if (jogo == 1) {
                clear();
                switch (random) {
                    case 1:
                        pilgrim pm = new pilgrim(pl.getLvl());
                        System.out.println("Apareceu um Peregrino!");
                        System.out.println("Quer saber mais sobre ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y'){
                            System.out.println();
                            System.out.println("O Peregrino é um misterioso personagem que percorre diferentes lugares em busca de novas aventuras e experiências.");
                            System.out.println();
                            System.out.println("Ele é conhecido por oferecer uma troca curiosa: se você der uma moeda a ele, o Peregrino irá lhe dar algo em troca.");
                            System.out.println("Essa troca pode ser algo útil e vantajoso para você, ou pode ser algo aparentemente inútil ou até mesmo algo que lhe atrapalhe!");
                            System.out.println();
                            System.out.println("De qualquer forma, o Peregrino é uma figura intrigante que desperta a curiosidade e o interesse das pessoas ao seu redor.");
                        } 

                        System.out.println();
                        System.out.println("O você aceita dar uma moeda para ele (s/n)? ");
                        opcao = sc.next().charAt(0);

                        
                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            if (pl.getMoeda() < 1) {
                                System.out.println("Mas cade as moedas??");
                            } else{
                                pl.downMoeda(1);
                                rdm = (int) ((Math.random() * 9) + 1);
                                pm.evento(rdm, pl);
                            }
                        } else if (opcao == 'n' || opcao == 'N') {
                            System.out.println("Esperava mais de você! " + pl.getNome());
                        }

                        System.out.println("Digite S para continuar...");
                        a = sc.next().charAt(0);

                        break;
                    case 2:
                        rdm = (int) ((Math.random() * 9) + 1);
                        System.out.println("Você achou " + rdm + "moedas no chão, deseja pegar (s/n)? ");
                        opcao = sc.next().charAt(0);

                        System.out.println();
                        if (opcao == 's' || opcao == 'y' || opcao == 'S' || opcao == 'Y') {
                            System.out.println("Você pegou as " + rdm + " moedas");
                            pl.upMoeda(rdm);
                        }

                        break;
                    default:
                        System.out.println("Erro, reinicei o jogo :C");
                        System.out.println("Digite S para continuar...");
                        a = sc.next().charAt(0);
                        break;
                }
            }
        }
        sc.close();
    }

    public static void clear() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else{
            new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
        }
    }
}