/*
 * 
 * @author helio
 * 
 */

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private Analisador analisador;
    private ArrayList<CorpoCeleste> planetas;
    int posicao;
    Random random;
    Jogador jogador;
    String log;

    public Jogo() {
        criarPlanetas();// cria os Planetas
        random = new Random();
        posicao = random.nextInt(planetas.size()); // define um Planeta aleatorio para iniciar o jogo
        jogador = new Jogador();
        jogador.setPlanetaAtual(planetas.get(posicao));
        analisador = new Analisador();
        log = "";
    }

    public void jogar() {
        imprimirBoasVindas();

        boolean terminado = false;

        while (!terminado) {
            String imprimir = ("==============================================================================================\n"
                    + "Planeta: " + jogador.getPlanetaAtual().getDescricao() + "\n" + "Energia: " + jogador.getEnergia()
                    + "\n" + "Plantas de arvore: " + jogador.getPlantasDeArvore() + "\n" + "Nave: "
                    + "\n"
                    + "Combustivel: " + jogador.getNave().getCombustivel() + "\n"
                    + "==============================================================================================\n"
                    + "Saidas: ");
            System.out.printf(imprimir);
            log += imprimir;
            imprimirSaidas();
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
        imprimirLog();
    }

    private boolean processarComando(Comando comando) {

        if (comando == null) {
            System.out.println("Comando invalido!");
            return false;
        }

        boolean querSair = false;
        String palavraGatilho = comando.getGatilho();
        System.out.println("palavra de comando: " + palavraGatilho);

        if (palavraGatilho.equals("quit")) {
            querSair = true;
        } else {
            switch (palavraGatilho) {
                case "plantar":
                    if (plantar()) {
                        querSair = true;
                    }
                    break;
                case "ir":
                    explorarPlaneta(comando);
                    break;
                case "viajar":
                    viajar(comando);
                    break;
                case "ajuda":
                    imprimirAjuda();
                    break;
                case "retornar":
                    jogador.retornarNave();
                    break;
                case "saber":
                    saberPlaneta();
                case "dica":
                    System.out.println(jogador.getPlanetaAtual().getDescricao());
                    break;
                default:
                    System.out.println("Comando invalido!");
                    break;
            }
        }
        return querSair;

    }

    private void saberPlaneta() {
        if (analisador.getSaberNomePlaneta().equals("sim")) {
            jogador.getNave().decrementarCombustivel(3, 4);
            System.out.println("Voce esta no planeta " + jogador.getPlanetaAtual().getNome());
        }
    }

    private boolean plantar() {
        if (jogador.plantarArvore()) {
            System.out.println("Parabens! Voce salvou a humanidade!");
            return true;
        } else {
            System.out.println("Voce nao esta no planeta certo para plantar a arvore da vida");
            if (jogador.getPlantasDeArvore() > 0) {
                System.out.println(
                        "Voce ainda tem " + jogador.getPlantasDeArvore() + " arvores para plantar");
            } else {
                System.out.println("Voce nao tem mais arvores para plantar");
                return true;
            }
        }
        return false;
    }

    private void imprimirAjuda() {
        System.out.println(
                "Voce esta em um planeta ou estrela desconhecido e precisa encontrar o planeta Terra para plantar a arvore da vida.");
        System.out.println("o que voce sabe sobre este planeta e: " + jogador.getPlanetaAtual().getDescricao());
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println(analisador.getComandosAceitos());
        System.out.println("\nir-> para explorar o planeta");
        System.out.println("viajar-> para viajar para outro planeta");
        System.out.println("plantar-> para plantar a arvore da vida");
        System.out.println("dica-> para saber mais sobre o planeta");
        System.out.println("retornar-> para voltar para a nave");
        System.out.println("ajuda-> para ver os comandos aceitos");
        System.out.println("quit-> para sair do jogo");
        System.out.println("saber-> para saber em qual planeta voce esta(pagando um preco bem alto)");

    }

    private void explorarPlaneta(Comando comando) {
        if (comando.getComplemento() != null) {
            System.out.println("comando: " + comando.getGatilho());
            System.out.println("destino: " + comando.getComplemento());
            if (comando.getComplemento().equals("sul")) {
                jogador.getPlanetaAtual().getAmbiente().avancarCenario();
                if (jogador.getPlanetaAtual().getAmbiente().getCenarioAtual().getItem() != null) {
                    verificarItem(jogador.getPlanetaAtual().getAmbiente().getCenarioAtual().getItem());
                }
                jogador.decrementarEnergia(1);
            } else if (comando.getComplemento().equals("norte")) {
                jogador.getPlanetaAtual().getAmbiente().retrocederCenario();
                jogador.decrementarEnergia(1);
            } else {
                System.out.println("destino invalido");
            }
        }
    }

    private boolean viajar(Comando comando) {
        if (jogador.getPlanetaAtual().getPosicao() != 0) {
            System.out.println("Voce precisa voltar para a nave antes de viajar");
        } else {
            if (comando.getComplemento() != null) {
                char operador;
                System.out.println("comando: " + comando.getGatilho());
                System.out.println("destino: " + comando.getComplemento());
                if (comando.getComplemento().equals("esquerda")) {
                    operador = '-';
                } else if (comando.getComplemento().equals("direita")) {
                    operador = '+';
                } else { // verifica se a direcao e valida
                    System.out.println("direcao invalida");
                    return false;
                }

                int distancia = comando.getDistancia();

                if (jogador.getNave().getCombustivel() < distancia) { // verifica se o jogador tem combustivel
                    System.out.println("Voce nao tem combustivel suficiente para viajar essa distancia");
                    return false;
                }

                if (operador == '+' && (planetas.indexOf(jogador.getPlanetaAtual()) + distancia) < planetas.size()) {
                    // verifica se o jogador nao vai ultrapassar o limite do array

                    jogador.viajar(distancia, planetas.get(planetas.indexOf(jogador.getPlanetaAtual()) + distancia));
                    return true;
                }
                if (operador == '-' && (planetas.indexOf(jogador.getPlanetaAtual()) - distancia) >= 0) {
                    // verifica se o jogador nao vai ultrapassar o limite do array

                    jogador.viajar(distancia, planetas.get(planetas.indexOf(jogador.getPlanetaAtual()) - distancia));
                    return true;
                }

            } else {
                System.out.println("destino invalido");
            }
        }
        return false;
    }

    public void verificarItem(String item) {
        System.out.println("Voce encontrou um " + item + "!");
        if (item == "java coffee") {
            jogador.incrementarEnergia(20);
            System.out.println("Voce recuperou 20 pontos de energia");
        }
        if (item == "rebimboca da parafuseta") {
            if (jogador.getNave().getEstado() == false) {
                jogador.getNave().consertar();
                System.out.println("Voce consertou a nave");
            }
        }
        if (item == "combustivel") {
            jogador.getNave().incrementarCombustivel(5);
            System.out.println("Voce recuperou 5 pontos de combustivel");
        }
    }

    private void criarPlanetas() {

        planetas = new ArrayList<CorpoCeleste>();

        Planeta mercurio = new Planeta("Mercurio",
                "Enfrenta extremos térmicos, com temperaturas que variam drasticamente entre o dia e a noite.");
        Planeta venus = new Planeta("Venus",
                "Envolto em uma atmosfera espessa e tóxica, é um mundo abrasador com uma paisagem árida e vulcões ativos");
        Planeta terra = new Planeta("Terra",
                "Aqui a temperatura e agradavel dependendo do local. voce esta em um planeta rochoso com uma ou mais luas ao redor.");
        Lua lua = new Lua("Lua",
                "Ilumina noites com crateras marcantes, mares escuros e uma paisagem intrigante.");
        Planeta marte = new Planeta("Marte",
                "Apresenta paisagens desérticas, cânions profundos e antigas planícies marcianas, além de ser objeto de busca por evidências de vida passada");
        Planeta jupiter = new Planeta("Jupiter",
                "Exibe uma atmosfera turbulenta com faixas coloridas e uma tempestade colossal.");
        Lua io = new Lua("Io",
                "é um mundo vulcânico marcado por uma superfície coberta por lava recente, geysers e montanhas coloridas.");
        Lua europa = new Lua("Europa",
                "possui uma crosta gelada que esconde um vasto oceano subsuperficial, tornando-a apta a abrigar vida.");
        Lua ganimedes = new Lua("Ganimedes",
                "exibe uma superfície com crateras antigas, sulcos e regiões mais jovens, indicando uma história geológica diversificada.");
        Lua calisto = new Lua("Calisto",
                "apresenta uma paisagem antiga com uma abundância de crateras, sugerindo uma ausência de atividade geológica significativa");
        Planeta saturno = new Planeta("Saturno",
                "Muito lindo visto do espaco, com uma estrutura impressionante e uma complexa dinâmica atmosférica.");
        Planeta urano = new Planeta("Urano",
                " Inclinado em seu eixo, destaca-se por sua atmosfera fria e pela presença de anéis e luas excêntricos.");
        Planeta netuno = new Planeta("Netuno",
                "envolto em ventos supersonicos e com uma atmosfera dinâmica, exibe uma coloração azul profunda e intrigantes características atmosféricas.");
        Planeta plutao = new Planeta("Plutao",
                "Sua atmosfera tênue, superfície gelada e lua carismática, revelam a complexidade deste mundo distante.");

        planetas.add(mercurio);
        planetas.add(venus);
        planetas.add(terra);
        planetas.add(lua);
        planetas.add(marte);
        planetas.add(jupiter);
        planetas.add(io);
        planetas.add(europa);
        planetas.add(ganimedes);
        planetas.add(calisto);
        planetas.add(saturno);
        planetas.add(urano);
        planetas.add(netuno);
        planetas.add(plutao);

    }

    private void imprimirBoasVindas() {

        System.out.println(pegarMensagemInicial());
        log += pegarMensagemInicial();
        System.out.println();
        String boasVindas = "planeta atual: " + jogador.getPlanetaAtual().getDescricao();
        System.out.println(boasVindas);
        log += boasVindas;

    }

    private void imprimirSaidas() {
        ArrayList<String> saidas = jogador.getPlanetaAtual().getAmbiente().getCenarioAtual().getSaida();

        for (String saida : saidas) {
            System.out.print(saida + " ");
            log += saida + " ";
        }
    }

    private void imprimirLog() {
        Arquivo log = new Arquivo(this.log);
        log.escrever();
    }

    private String pegarMensagemInicial() {
        return ("Bem-vindo ao Fundacao Terra!\n" +
                "\nFundacao Terra eh um novo jogo de aventura incrivelmente chato.\n" +
                "\nDigite 'ajuda' se voce precisar de ajuda.\n" +
                "\nMuitos anos atras, antes mesmo da grande Colisao, a humanidade saia de seu planeta natal para explorar o espaço.\n"
                +
                "\nApos a Colisao, a humanidade se viu presa em uma nova super-galaxia hostil e desconhecida, com muitas de suas colonias sendo ameacadas constantemente\n"
                +
                "\nAs escritas antigas indicam que o berço da vida humana se encontra em um planeta azul rochoso com uma ou mais luas ao redor.\n"
                +
                "\nAquele e o unico lugar onde a arvore da vida pode ser plantada em toda a super-galaxia.\n" +
                "\nTudo indica que voce esta no sistema planetario certo. Agora voce precisa encontrar o planeta e garantir nossa existencia que depende da arvore da vida.\n"
                +
                "\nSeu combustivel e escasso, entao voce precisa ser rapido e eficiente.\n" +
                "\nDurante sua jornada, voce pode sofrer com tempestades solares, chuvas de asteroides ou ate mesmo com a falta de energia.\n"
                +
                "\nBoa sorte!\n");
    }
}
