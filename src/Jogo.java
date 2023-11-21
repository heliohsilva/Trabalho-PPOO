import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;
    private ArrayList<Ambiente> ambientes;
    int posicao;
    Random random;

    public Jogo() {
        criarAmbientes();// cria os ambientes
        random = new Random();
        posicao = random.nextInt(ambientes.size()); // define um ambiente aleatorio para iniciar o jogo
        ambienteAtual = ambientes.get(posicao);
        analisador = new Analisador(ambienteAtual.getTipo(), posicao);
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

    private void irParaAmbiente(Comando comando) {
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

    private void criarAmbientes() {

        ambientes = new ArrayList<Ambiente>();

        Ambiente mercurio = new Ambiente("planeta",
                "Enfrenta extremos térmicos, com temperaturas que variam drasticamente entre o dia e a noite.");
        Ambiente venus = new Ambiente("planeta",
                "Envolto em uma atmosfera espessa e tóxica, é um mundo abrasador com uma paisagem árida e vulcões ativos");
        Ambiente terra = new Ambiente("planeta",
                "Aqui a temperatura e agradavel dependendo do local. voce esta em um planeta rochoso com uma ou mais luas ao redor.");
        Ambiente lua = new Ambiente("lua",
                "Ilumina noites com crateras marcantes, mares escuros e uma paisagem intrigante.");
        Ambiente marte = new Ambiente("planeta",
                "Apresenta paisagens desérticas, cânions profundos e antigas planícies marcianas, além de ser objeto de busca por evidências de vida passada");
        Ambiente jupiter = new Ambiente("planeta",
                "Exibe uma atmosfera turbulenta com faixas coloridas e uma tempestade colossal.");
        Ambiente io = new Ambiente("lua",
                "é um mundo vulcânico marcado por uma superfície coberta por lava recente, geysers e montanhas coloridas.");
        Ambiente europa = new Ambiente("lua",
                "possui uma crosta gelada que esconde um vasto oceano subsuperficial, tornando-a apta a abrigar vida.");
        Ambiente ganimedes = new Ambiente("lua",
                "exibe uma superfície com crateras antigas, sulcos e regiões mais jovens, indicando uma história geológica diversificada.");
        Ambiente calisto = new Ambiente("lua",
                "apresenta uma paisagem antiga com uma abundância de crateras, sugerindo uma ausência de atividade geológica significativa");
        Ambiente saturno = new Ambiente("planeta",
                "Muito lindo visto do espaco, com uma estrutura impressionante e uma complexa dinâmica atmosférica.");
        Ambiente urano = new Ambiente("planeta",
                " Inclinado em seu eixo, destaca-se por sua atmosfera fria e pela presença de anéis e luas excêntricos.");
        Ambiente netuno = new Ambiente("planeta",
                "envolto em ventos supersonicos e com uma atmosfera dinâmica, exibe uma coloração azul profunda e intrigantes características atmosféricas.");
        Ambiente plutao = new Ambiente("planeta",
                "Sua atmosfera tênue, superfície gelada e lua carismática, revelam a complexidade deste mundo distante.");

        ambientes.add(mercurio);
        ambientes.add(venus);
        ambientes.add(terra);
        ambientes.add(lua);
        ambientes.add(marte);
        ambientes.add(jupiter);
        ambientes.add(io);
        ambientes.add(europa);
        ambientes.add(ganimedes);
        ambientes.add(calisto);
        ambientes.add(saturno);
        ambientes.add(urano);
        ambientes.add(netuno);
        ambientes.add(plutao);
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

        System.out.println("planeta atual: " + ambienteAtual.getDescricao());

        System.out.print("Saidas: ");
    }
}
