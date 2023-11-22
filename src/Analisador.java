import java.util.Scanner;
import java.util.ArrayList;

public class Analisador {
    private PalavrasComando comandosAceitos;
    private Scanner in;

    public Analisador() {
        in = new Scanner(System.in);
    }

    public String getComandosAceitos() {
        return comandosAceitos.getComandos();
    }

    public Comando pegarComando() {
        String linha;

        System.out.print("> ");
        linha = in.nextLine();

        ArrayList<String> palavras = new ArrayList<String>();
        Scanner splitString = new Scanner(linha);

        if (splitString.hasNext()) {
            palavras.add(splitString.next());

            if (splitString.hasNext()) {
                palavras.add(splitString.next());
            }
        }

        splitString.close();
        if (!palavras.isEmpty()) {
            return new Comando(palavras);
        }
        return null;
    }

}
