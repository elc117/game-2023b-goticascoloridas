import java.util.ArrayList;
import java.util.List;

public class JardimBotanico {
    private List<Pergunta> perguntas;

    public JardimBotanico() {
        perguntas = new ArrayList<>();
        // Adicione suas perguntas aqui
        perguntas.add(new Pergunta("Qual é a maior árvore do jardim?", "Sequoia"));
        perguntas.add(new Pergunta("Quais são os benefícios da fotossíntese?", "Produção de oxigênio e açúcares"));
        perguntas.add(new Pergunta("Como as plantas capturam a luz solar?", "Através da clorofila nas células"));
        // Continue adicionando perguntas conforme necessário
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public static void main(String[] args) {
        JardimBotanico jardim = new JardimBotanico();

        List<Pergunta> perguntas = jardim.getPerguntas();
        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta pergunta = perguntas.get(i);
            System.out.println("Pergunta " + (i + 1) + ": " + pergunta.getPergunta());
            System.out.println("Resposta: " + pergunta.getResposta());
            System.out.println();
        }
    }
}
