
import java.util.ArrayList;
import java.util.Random;

//ambiente interno de um planeta. contem sessoes exploraveis(mapa interno)
public class AmbienteInterno {
    private ArrayList<Cenario> cenarios;
    private int quantidadedeCenarios;

    private Cenario cenarioAtual;

    // cada planeta tem um ambiente interno composto por um numero aleatorio de
    // cenarios
    // cada cenario tem uma ou duas saidas e pode ou nao ter algum item

    public AmbienteInterno(String nome) {
        cenarios = new ArrayList<Cenario>();
        quantidadedeCenarios = new Random().nextInt(9) + 1; // de 1 a 10

        for (int i = 0; i < quantidadedeCenarios; i++) {
            if (i == 0) {
                cenarios.add(new Cenario(true, false));
            } else if (i == quantidadedeCenarios - 1) {
                cenarios.add(new Cenario(false, true));
            } else {
                cenarios.add(new Cenario(false, false));
            }
        }

        cenarioAtual = cenarios.get(0);
    }

    public Cenario getCenarioAtual() {
        return cenarioAtual;
    }

    public void avancarCenario() {
        cenarioAtual = cenarios.get(cenarios.indexOf(cenarioAtual) + 1);
    }

    public void retrocederCenario() {
        cenarioAtual = cenarios.get(cenarios.indexOf(cenarioAtual) - 1);
    }

}
