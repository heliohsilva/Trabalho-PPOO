
//@author iara
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class JogoInterface {

    private Jogador jogador;
    private Nave nave;
    private Jogo jogo;
    private JFrame frame;
    private JLabel titulo;
    private JLabel imgLabel1;
    private JLabel combustivel;
    private JLabel tiros;
    private JLabel mudas;
    private JLabel energia;
    private JLabel tituloAcao;
    private JLabel dica; // planetas.get(posicao)
    private JTextField acaoEscolhida;
    private JButton enviarButton;

    public JogoInterface(Jogador jogador, Nave nave, Jogo jogo) {
        this.jogador = jogador;
        this.nave = nave;
        this.jogo = jogo;

        frame = new JFrame("Fundação Terra");
        titulo = new JLabel("Fundação Terra", SwingConstants.CENTER);
        combustivel = new JLabel("Combustível restante: " + nave.getCombustivel(), SwingConstants.LEFT);
        tiros = new JLabel("Tiros restantes: ", SwingConstants.LEFT); // colocar tiros restante
        mudas = new JLabel("Mudas restantes: " + jogador.getPlantasDeArvore(), SwingConstants.LEFT);
        energia = new JLabel("Energia restante: " + jogador.getEnergia(), SwingConstants.LEFT);
        dica = new JLabel("Dica: ");

        imgLabel1 = new JLabel("", SwingConstants.CENTER);

        tituloAcao = new JLabel(
                "Escolha uma ação. As ações permitidas são: ir, quit, ajuda, plantar, dica, viajar, retornar, saber.");

        ArrayList<String> listaDeComandos = new ArrayList<>();
        acaoEscolhida = new JTextField(" ");
        enviarButton = new JButton("Enviar Comando");

        enviarButton.addActionListener((ActionEvent e) -> {

            String comandoDigitado = acaoEscolhida.getText().trim().toLowerCase();
            listaDeComandos.add(comandoDigitado);
            acaoEscolhida.setText(""); // limpa
            Comando comando = new Comando(listaDeComandos);
            processarAcao(comando);
            listaDeComandos.clear(); // ta limpando tudo e reconhecendo todas palavras com comando
        });

        montarFrame(); // monta o frame
    }

    public void configurarLabel() {
        titulo.setFont(new Font("Arial", Font.BOLD, 30)); // ajusta o tamanho da fonte
        combustivel.setFont(new Font("Arial", Font.PLAIN, 18));
        tiros.setFont(new Font("Arial", Font.PLAIN, 18));
        mudas.setFont(new Font("Arial", Font.PLAIN, 18));
        energia.setFont(new Font("Arial", Font.PLAIN, 18));
        tituloAcao.setFont(new Font("Arial", Font.PLAIN, 18));
        dica.setFont(new Font("Arial", Font.PLAIN, 18));
    }

    private void configurarImagem() {
        ImageIcon sistemaSolar = new ImageIcon("../img/sistemaSolar.jpg");
        imgLabel1.setIcon(sistemaSolar);
    }

    public void configurarPainel() {

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        acaoEscolhida.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(acaoEscolhida, BorderLayout.CENTER);
        inputPanel.add(enviarButton, BorderLayout.EAST);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel dadosPanel = new JPanel();
        dadosPanel.setLayout(new BoxLayout(dadosPanel, BoxLayout.Y_AXIS)); // vertical

        // Adiciona dados sobre o jogador no painel na esquerda
        dadosPanel.add(combustivel);
        dadosPanel.add(mudas);
        dadosPanel.add(tiros);
        dadosPanel.add(energia);
        mainPanel.add(dadosPanel, BorderLayout.WEST);

        // Adiciona imagem
        configurarImagem();

        JPanel centerPanel = new JPanel(new GridLayout(1, 1));

        centerPanel.add(imgLabel1);

        // Adiciona o painel centralizado no centro
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Adiciona a caixa de texto e o botão
        JPanel acaoPanel = new JPanel();
        acaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        acaoPanel.add(tituloAcao);
        acaoPanel.add(inputPanel);

        mainPanel.add(acaoPanel, BorderLayout.SOUTH);

        configurarFrame(mainPanel);
    }

    public void configurarFrame(JPanel mainPanel) {
        // Ajusta o tamanho e define o layout
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        frame.add(titulo, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.pack();
    }

    private void processarAcao(Comando comando) {
        processarAcao(comando);
    }

    public void mudarInterface(Comando comando) {
        String comandoDigitado = comando.getGatilho();

    }

    public void montarFrame() {
        configurarImagem();
        configurarLabel();
        configurarPainel();
    }

    public void exibir() {
        frame.setVisible(true);
    }
}
