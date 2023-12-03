//author iara 
public class Programa {
	public static void main(String[] args) {

		Nave nave = new Nave();
		Jogo jogo = new Jogo();
		JogoInterface jogoInterface = new JogoInterface(nave, jogo);
		jogoInterface.exibir();
		jogo.jogar();

	}

}
