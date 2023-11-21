public class PalavrasComando {

    private String[] comandosValidos;

    public PalavrasComando(String tipoDeAmbiente/* planeta ou nave */, int posicao) {
        if (tipoDeAmbiente == "planeta") {
            if (posicao == 1) { // posicao inicial
                comandosValidos = new String[] { "plantar", "explorar", "nave", "quit", "ajuda" };
            } else if (posicao == 2) { // posicao nao inicial
                comandosValidos = new String[] { "plantar", "explorar", "voltarInicio", "quit", "ajuda" };
            }

        } else if (tipoDeAmbiente == "nave") {
            comandosValidos = new String[] { "viajar", "quit", "ajuda" };
        }
    }

    public boolean ehComando(String umaString) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(umaString)) {
                return true;
            }
        }
        return false;
    }

    public String comandosValidos() {
        String comandos = "";
        for (int i = 0; i < comandosValidos.length; i++) {
            comandos += comandosValidos[i] + " ";
        }
        return comandos;
    }
}