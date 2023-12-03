//author iara 
public class Programa {
	public static void main(String[] args) {

		Jogador jogador = new Jogador();
		Nave nave = new Nave();
		Jogo jogo = new Jogo();
		JogoInterface jogoInterface = new JogoInterface(jogador, nave, jogo);
		jogoInterface.exibir();
		jogo.jogar();

	}

}
