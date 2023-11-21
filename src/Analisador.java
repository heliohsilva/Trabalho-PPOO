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

}
