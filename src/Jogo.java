import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private Analisador analisador;
    private Planeta PlanetaAtual;
    private ArrayList<Planeta> Planetas;
    int posicao;
    Random random;

    public Jogo() {
        criarPlanetas();// cria os Planetas
        random = new Random();
        posicao = random.nextInt(Planetas.size()); // define um Planeta aleatorio para iniciar o jogo
        PlanetaAtual = Planetas.get(posicao);
        analisador = new Analisador(PlanetaAtual.getTipo(), posicao);
    }

    public void jogar() {
        imprimirBoasVindas();

        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    private boolean processarComando(Comando comando) {
        boolean querSair = false;
        return querSair;
    }

    private void imprimirAjuda() {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce caminha");
        System.out.println("pela universidade.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("   ir sair ajuda");
    }

    private void irParaPlaneta(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            System.out.println("Ir pra onde?");
            return;
        }
    }

    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true;
        }
    }

    private void criarPlanetas() {

        Planetas = new ArrayList<Planeta>();

        Planeta mercurio = new Planeta("mercurio", "planeta",
                "Enfrenta extremos térmicos, com temperaturas que variam drasticamente entre o dia e a noite.");
        Planeta venus = new Planeta("venus", "planeta",
                "Envolto em uma atmosfera espessa e tóxica, é um mundo abrasador com uma paisagem árida e vulcões ativos");
        Planeta terra = new Planeta("terra", "planeta",
                "Aqui a temperatura e agradavel dependendo do local. voce esta em um planeta rochoso com uma ou mais luas ao redor.");
        Planeta lua = new Planeta("lua", "lua",
                "Ilumina noites com crateras marcantes, mares escuros e uma paisagem intrigante.");
        Planeta marte = new Planeta("marte", "planeta",
                "Apresenta paisagens desérticas, cânions profundos e antigas planícies marcianas, além de ser objeto de busca por evidências de vida passada");
        Planeta jupiter = new Planeta("jupiter", "planeta",
                "Exibe uma atmosfera turbulenta com faixas coloridas e uma tempestade colossal.");
        Planeta io = new Planeta("io", "lua",
                "é um mundo vulcânico marcado por uma superfície coberta por lava recente, geysers e montanhas coloridas.");
        Planeta europa = new Planeta("europa", "lua",
                "possui uma crosta gelada que esconde um vasto oceano subsuperficial, tornando-a apta a abrigar vida.");
        Planeta ganimedes = new Planeta("ganimedes", "lua",
                "exibe uma superfície com crateras antigas, sulcos e regiões mais jovens, indicando uma história geológica diversificada.");
        Planeta calisto = new Planeta("calisto", "lua",
                "apresenta uma paisagem antiga com uma abundância de crateras, sugerindo uma ausência de atividade geológica significativa");
        Planeta saturno = new Planeta("saturno", "planeta",
                "Muito lindo visto do espaco, com uma estrutura impressionante e uma complexa dinâmica atmosférica.");
        Planeta urano = new Planeta("urano", "planeta",
                " Inclinado em seu eixo, destaca-se por sua atmosfera fria e pela presença de anéis e luas excêntricos.");
        Planeta netuno = new Planeta("netuno", "planeta",
                "envolto em ventos supersonicos e com uma atmosfera dinâmica, exibe uma coloração azul profunda e intrigantes características atmosféricas.");
        Planeta plutao = new Planeta("plutao", "planeta",
                "Sua atmosfera tênue, superfície gelada e lua carismática, revelam a complexidade deste mundo distante.");

        Planetas.add(mercurio);
        Planetas.add(venus);
        Planetas.add(terra);
        Planetas.add(lua);
        Planetas.add(marte);
        Planetas.add(jupiter);
        Planetas.add(io);
        Planetas.add(europa);
        Planetas.add(ganimedes);
        Planetas.add(calisto);
        Planetas.add(saturno);
        Planetas.add(urano);
        Planetas.add(netuno);
        Planetas.add(plutao);
    }

    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao Fundacao Terra!");
        System.out.println("Fundacao Terra eh um novo jogo de aventura incrivelmente chato.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println(
                "Muitos anos atras, antes mesmo da grande Colisao, a humanidade saia de seu planeta natal para explorar o espaço.");
        System.out.println(
                "Apos a Colisao, a humanidade se viu presa em uma nova super-galaxia hostil e desconhecida, com muitas de suas colonias sendo ameacadas constantemente");
        System.out.println(
                "As escritas antigas indicam que o berço da vida humana se encontra em um planeta azul rochoso com uma ou mais luas ao redor.");
        System.out.println("Aquele e o unico lugar onde a arvore da vida pode ser plantada em toda a super-galaxia.");
        System.out.println(
                "Tudo indica que voce esta no sistema planetario certo. Agora voce precisa encontrar o planeta e garantir nossa existencia que depende da arvore da vida.");
        System.out.println("Seu combustivel e escasso, entao voce precisa ser rapido e eficiente.");
        System.out.println(
                "Durante sua jornada, voce pode sofrer com tempestades solares, chuvas de asteroides ou ate mesmo com a falta de energia.");
        System.out.println("Boa sorte!");
        System.out.println();

        System.out.println("planeta atual: " + PlanetaAtual.getDescricao());

        System.out.print("Saidas: ");
    }
}
