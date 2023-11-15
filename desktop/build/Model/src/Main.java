import java.util.Scanner;
import Model.JardimBotanico;
public class Main {
    public static void main(String[] args) {
        JardimBotanico jardimBotanico = new JardimBotanico();
        Scanner scanner = new Scanner(System.in);

        for (Pergunta pergunta : jardimBotanico.getPerguntas()) {
            System.out.println(pergunta.getPergunta());
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase(pergunta.getResposta())) {
                System.out.println("Resposta correta!");
            } else {
                System.out.println("Resposta errada. A resposta correta é: " + pergunta.getResposta());
            }
        }

        scanner.close();
    }
}
