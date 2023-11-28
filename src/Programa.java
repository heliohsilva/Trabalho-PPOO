
public class Programa {
	public static void main(String[] args) {

		JogoInterface jogoInterface = new JogoInterface();
		jogoInterface.exibir();

		Jogo jogo = new Jogo();
		jogo.jogar();

	}

}
