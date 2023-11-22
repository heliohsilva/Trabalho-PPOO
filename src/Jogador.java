import java.util.Random;

public class Jogador {
    private String[] itens;
    private int plantasDeArvore;
    private int energia; // usada para explorar planetas. resetada sempre que o jogador viaja
    private Planeta planetaAtual;
    private Nave nave;
    private Random rand;

    public Jogador() {
        itens = new String[3];
        energia = 100;
        plantasDeArvore = 3;
        nave = new Nave();
        rand = new Random();
    }

    public int getEnergia() {
        return energia;
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

    public Planeta getPlanetaAtual() {
        return planetaAtual;
    }

    public void saberPlaneta() {
        Analisador analisador = new Analisador();

        String resposta = analisador.getSaberNomePlaneta();

        if (resposta.equals("sim")) {
            saberNomePlanetaAtual();
        } else if (resposta.equals("nao")) {
            System.out.println("resposta de um verdadeiro sabio");
        } else {
            System.out.println("resposta invalida");
        }
    }

    public void usarItem(String item) {
        if (item == "java coffee") {
            incrementarEnergia(20);

        }
        if (item == "rebimboca da parafuseta") {
            if (!nave.getEstado()) {
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
        int chanceDeDesafio = rand.nextInt(3);

        if (chanceDeDesafio == 0) {
            String[] desafios = { "tempestade solar", "chuva de asteroides", "buraco negro" };

            int desafio = rand.nextInt(3); // de 0 a 2

            if (desafio == 0) {
                System.out.printf("Voce foi surpreendido por uma %s e foi atordoado%n", desafios[0]);
                System.out.print("Depois de um tempo voce acorda e percebe que foi jogado para um planeta aleatorio");

                // implementar planeta aleatorio
            }
            if (desafio == 1) {
                System.out.printf("Voce foi surpreendido por uma %s e sua nave quebrou%n", desafios[1]);
                System.out.print(
                        "Voce e obrigado a pousar no planeta mais proximo para procurar pecas para conserta-la");

                nave.quebrar();
                // implementar sistema de spawnar rebimboca da parafuseta no planeta em questao

            }
            if (desafio == 2) {
                System.out.printf(
                        "Voce esta sendo sugado por um %s e precisa acelerar ao maximo para conseguir escapar%n",
                        desafios[2]);

                // fazer sisteminha para o jogador escolher acelerar e perder combustivel ou nao
                // acelerar e morrer

            }
        }

        planetaAtual = planeta;
    }

    public void retornarNave() {
        while (planetaAtual.getPosicao() != 0) {
            planetaAtual.retrocederCenario();
            decrementarEnergia(1);
        }
    }

    public Nave getNave() {
        return nave;
    }

    public void setPlanetaAtual(Planeta planeta) {
        planetaAtual = planeta;
    }

    public void saberNomePlanetaAtual() {// uma operacao bem cara que mostra para o jogador o nome do planeta atual pelo
                                         // preco de 3/4 do combustivel da nave.
        nave.decrementarCombustivel(3, 4);
        System.out.println("Voce esta no planeta " + planetaAtual.getNome());

    }

}
