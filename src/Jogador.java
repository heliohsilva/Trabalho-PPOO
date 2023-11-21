public class Jogador {
    private String[] itens;
    private int plantasDeArvore;
    private int energia; // usada para explorar planetas. resetada sempre que o jogador viaja

    public Jogador() {
        itens = new String[3];
        energia = 100;
        plantasDeArvore = 3;
    }

    public void resetEnergia() {
        energia = 100;
    }

    public void incrementarEnergia(int incremento) {
        energia += incremento;
    }

    public void decrementarEnergia(int decremento) {
        energia -= decremento;
    }

    public void plantarArvore() {
        plantasDeArvore--;
    }

    public int getPlantasDeArvore() {
        return plantasDeArvore;
    }

}
