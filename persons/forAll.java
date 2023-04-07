package persons;

public class forAll {

    public forAll() {
    }

    public String getNome(int persons){
        String nomes[] = {"Peregrino"};
        return nomes[persons];
    }

    public Object getDescPersons(int persons){
        Object descPersons[] = {getDescPeregrino()};
        return descPersons[persons];
    }

    public String getDescPeregrino(){
        return "\n" +
                "O Peregrino é um misterioso personagem que percorre diferentes lugares em busca de novas aventuras e experiências." +
                "\n" +
                "Ele é conhecido por oferecer uma troca curiosa: se você der uma moeda a ele, o Peregrino irá lhe dar algo em troca." +
                "\n" +
                "Essa troca pode ser algo útil e vantajoso para você, ou pode ser algo aparentemente inútil ou até mesmo algo que lhe atrapalhe!" +
                "\n" +
                "De qualquer forma, o Peregrino é uma figura intrigante que desperta a curiosidade e o interesse das pessoas ao seu redor.";
    }
}
