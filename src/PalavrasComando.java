public class PalavrasComando {

    private String[] comandosValidos;

    public PalavrasComando(String tipoDeAmbiente, int posicao) {
        if (tipoDeAmbiente == "planeta") {
            if (posicao == 1) { // posicao inicial
                comandosValidos = new String[] { "explorar planeta", "entrar na nave", "quit", "ajuda" };
            } else if (posicao == 2) { // posicao nao inicial
                comandosValidos = new String[] { "explorar", "voltar para a nave", "quit", "ajuda" };
            }
        } else if (tipoDeAmbiente == "nave") {
            comandosValidos = new String[] { "viajar para outro planeta", "quit", "ajuda" };
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