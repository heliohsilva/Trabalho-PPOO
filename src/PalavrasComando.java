public class PalavrasComando {

    private String[] comandosValidos;

    public PalavrasComando() {

        comandosValidos = new String[] { "ir", "quit", "ajuda", "plantar", "pegar", "dica", "viajar", "retornar" };
        // ir remete a explorar o mundo em que a nave pousou e viajar e ir para outro
        // mundo
    }

    public boolean ehComando(String umaString) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(umaString)) {
                return true;
            }
        }
        return false;
    }

    public String getComandos() {
        String comandos = "";

        for (int i = 0; i < comandosValidos.length; i++) {
            comandos += comandosValidos[i] + " ";
        }

        return comandos;

    }
}