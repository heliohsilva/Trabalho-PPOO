import java.util.Scanner;
import java.util.ArrayList;

public class Analisador {
    private PalavrasComando palavrasDeComando;
    private Scanner entrada;

    public Analisador(String tipoDeAmbiente, int posicao) {
        palavrasDeComando = new PalavrasComando(tipoDeAmbiente, posicao);
        entrada = new Scanner(System.in);
    }

    /**
     * @return O proximo comando do usuario
     */
    public Comando pegarComando() {
        String linha; // guardara uma linha inteira
        String palavra1 = null;
        ArrayList<String> palavras = new ArrayList<String>();

        System.out.print("> "); // imprime o prompt

        linha = entrada.nextLine();

        // Tenta encontrar ate duas palavras na linha
        Scanner tokenizer = new Scanner(linha);
        if (tokenizer.hasNext()) {
            palavra1 = tokenizer.next(); // pega a primeira palavra
            if (tokenizer.hasNext()) {
                palavras.add(tokenizer.next()); // pega a segunda palavra
                // obs: nos simplesmente ignoramos o resto da linha.
            }
        }

        // Agora verifica se esta palavra eh conhecida. Se for, cria um comando
        //
        // com ela. Se nao, cria um comando "null" (para comando desconhecido)
        if (palavrasDeComando.ehComando(palavra1)) {
            return new Comando(palavra1, palavras);
        } else {
            return new Comando(null, palavras);
        }

    }
}
