public class Jogador {
    private String[] itens;
    private int plantasDeArvore;
    private int energia; // usada para explorar planetas. resetada sempre que o jogador viaja
    private Planeta planetaAtual;
    private Nave nave;

    public Jogador() {
        itens = new String[3];
        energia = 100;
        plantasDeArvore = 3;
        nave = new Nave();
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

    public boolean plantarArvore() {
        if (planetaAtual.getNome() == "Terra") {
            return true;
        } else {
            plantasDeArvore--;

            return false;
        }
    }

    public int getPlantasDeArvore() {
        return plantasDeArvore;
    }

    public void usarItem(String item) {
        if (item == "java coffee") {
            incrementarEnergia(20);

        }
        if (item == "rebimboca da parafuseta") {
            if (nave.getEstado() == false) {
                nave.consertar();
            }
        }
        if (item == "combustivel") {
            nave.incrementarCombustivel(5);
        }
    }

    public void viajar(int combustivelGasto, Planeta planeta) {
        resetEnergia();

        nave.decrementarCombustivel(combustivelGasto);
        planetaAtual = planeta;
    }

    public Nave getNave() {
        return nave;
    }

    public void setPlanetaAtual(Planeta planeta) {
        planetaAtual = planeta;
    }

    public void saberNomePlanetaAtual() {// uma operacao bem cara que mostra para o jogador o nome do planeta atual pelo
                                         // preco de 3/4 do combustivel da nave.
        System.out.println("Voce esta no planeta " + planetaAtual.getNome());

        nave.decrementarCombustivel(3, 4);
    }

}
