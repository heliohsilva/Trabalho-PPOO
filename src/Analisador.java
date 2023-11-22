import java.util.Scanner;
import java.util.ArrayList;

public class Analisador {
    private PalavrasComando comandosAceitos;
    private Scanner in;

    public Analisador() {
        in = new Scanner(System.in);
        comandosAceitos = new PalavrasComando();
    }

    public String getComandosAceitos() {
        return comandosAceitos.getComandos();
    }

    public String getSaberNomePlaneta() {
        System.out.print(
                "voce tem certeza de que quer saber o nome do planeta atual? isso vai custar 3/4 do seu combustivel? ");
        return in.nextLine();
    }

    public int getDistanciaViagem() {
        System.out.print("\nQuantos planetas deseja viajar? ");
        return in.nextInt();
    }

    public Comando pegarComando() {
        String linha;
        String comandoValidos = comandosAceitos.getComandos();

        System.out.print("\nComandos validos: ");

        for (String comando : comandoValidos.split(" ")) {
            System.out.print(comando + " | ");
        }

        System.out.print("\n\n> ");

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
