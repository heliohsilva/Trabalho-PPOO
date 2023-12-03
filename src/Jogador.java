/*
 * @author helio e fernando
 */

import java.util.Random;
import java.util.Scanner;

public class Jogador {
    private Inventario mochila;
    private int plantasDeArvore;
    private int energia; // usada para explorar planetas. resetada sempre que o jogador viaja
    private CorpoCeleste planetaAtual;
    private Nave nave;
    private Random rand;

    public Jogador() {
        mochila = new Inventario();
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

    public int getPlantasDeArvore() {
        return plantasDeArvore;
    }

    public CorpoCeleste getPlanetaAtual() {
        return planetaAtual;
    }

    public Nave getNave() {
        return nave;
    }

    public void setPlanetaAtual(CorpoCeleste planeta) {
        planetaAtual = planeta;
    }

    public boolean plantarArvore() {
        if (planetaAtual.getNome() == "Terra") {
            return true;
        } else {
            plantasDeArvore--;

            return false;
        }
    }

    public void viajar(int combustivelGasto, CorpoCeleste planeta) {
        resetEnergia();
        setPlanetaAtual(planeta);
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

    }

    public void retornarNave() {
        while (planetaAtual.getPosicao() != 0) {
            planetaAtual.getAmbiente().retrocederCenario();
            decrementarEnergia(1);
        }
    }

    public void pegarItem() { // Fernando: adicionei esse método 
        if (planetaAtual.getAmbiente().getCenarioAtual().getTemItem() == true) { // Se o cenario atual tiver um item
            String nomeItem = planetaAtual.getAmbiente().getCenarioAtual().getItem();
            planetaAtual.getAmbiente().getCenarioAtual().removeItem(); // O item é retirado do cenario 
            mochila.adicionarItem(nomeItem);
            System.out.println("Voce pegou o item!!");
        }
        System.out.println("Veja sua mochila: ");
        verificarMochila();
    } 

    public void verificarMochila() { // Fernando
        mochila.listarItens();
    }

    public void usarItem(String item) { // Fernando

        if (mochila.mochilaVazia()) {
            System.out.println("Nao ha itens no inventario");
        } else {
            System.out.println("Verifique os itens disponiveis para uso");
            verificarMochila();
            System.out.println("Insira o item que deseja usar: ")
            Scanner scn = new Scanner(System.in);
            String entrada = scn.nextLine();

            if (mochila.verificarItem(entrada)) {
                if (entrada == "java coffee") {
                    incrementarEnergia(20);
                    mochila.removerItem(entrada);
                }
                if (entrada == "rebimboca da parafuseta") {
                    if (!nave.getEstado()) {
                        nave.consertar();
                        mochila.removerItem(entrada);
                    }
                }
                if (entrada == "combustivel") {
                    nave.incrementarCombustivel(5);
                    mochila.removerItem(entrada);
                }
            }
        }

    }
}
