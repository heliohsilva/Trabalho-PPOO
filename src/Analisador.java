import java.util.Scanner;
import java.util.ArrayList;

public class Analisador {
    private PalavrasComando palavrasDeComando;
    private Scanner entrada;

    String tipoDeAmbiente;
    int posicao;

    public Analisador(String tipoDeAmbiente, int posicao) {
        this.tipoDeAmbiente = tipoDeAmbiente;
        this.posicao = posicao;
        palavrasDeComando = new PalavrasComando(tipoDeAmbiente, posicao);
        entrada = new Scanner(System.in);
    }

    public Comando pegarComando() {
        String linha; // guardara toda a linha
        ArrayList<String> palavras = new ArrayList<String>(); // guardara as palavras da linha

        System.out.print("> "); // imprime o prompt

        linha = entrada.nextLine(); // le a linha inteira
        Scanner tokenizer = new Scanner(linha); // quebra a linha em palavras
        while (tokenizer.hasNext()) {
            palavras.add(tokenizer.next()); // adiciona cada palavra na lista
        }

        if (palavrasDeComando.ehComando(palavras.get(0)) == false) {
            System.out.println("Comando invalido!");
            return new Comando(null);
        } else {
            return new Comando(palavras);
        }

    }

}
