
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

    public JogoInterface(Nave nave, Jogo jogo) {

        this.nave = nave;
        this.jogo = jogo;
        jogador = jogo.getJogador();

        frame = new JFrame("Fundação Terra");
        titulo = new JLabel("Fundação Terra", SwingConstants.CENTER);
        combustivel = new JLabel("Combustível restante: " + nave.getCombustivel(), SwingConstants.LEFT);
        tiros = new JLabel("Tiros restantes: ", SwingConstants.LEFT); // colocar tiros restante
        mudas = new JLabel("Mudas restantes: " + jogador.getPlantasDeArvore(), SwingConstants.LEFT);
        energia = new JLabel("Energia restante: " + jogador.getEnergia(), SwingConstants.LEFT);
        dica = new JLabel("Dica: " + jogador.getPlanetaAtual().getDescricao());

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

        // adiciona painel esquerdo
        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.LIGHT_GRAY); // TEST
        actionPanel.setPreferredSize(new Dimension(100, imgLabel1.getHeight()));

        centerPanel.add(actionPanel, BorderLayout.WEST);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Adiciona a caixa de texto e o botão
        JPanel acaoPanel = new JPanel();
        acaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        acaoPanel.add(tituloAcao);
        acaoPanel.add(inputPanel);

        // Adiciona a caixa de texto e o botão
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(dica, BorderLayout.NORTH); // Adiciona a etiqueta dica acima do acaoPanel
        bottomPanel.add(acaoPanel, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
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

        // String comandoDigitado = comando.getGatilho();

        // if (comandoDigitado.equals("quit")) {

        // frame.dispose();

        // } else if (comandoDigitado.equals("ir")) { // quebrado

        // jogo.explorarPlaneta(comando);

        // } else if (comandoDigitado.equals("plantar")) {

        // if (jogo.plantar()) {
        // System.out.println("funfa");
        // }

        // } else if (comandoDigitado.equals("saber")) { // quebrado

        // jogo.saberPlaneta();

        // } else if (comandoDigitado.equals("viajar")) {

        // jogo.viajar(comando);

        // } else if (comandoDigitado.equals("ajuda")) {

        // jogo.imprimirAjuda();

        // } else if (comandoDigitado.equals("retornar")) { // quebrado

        // jogador.retornarNave();

        // } else if (comandoDigitado.equals("dica")) { // quebrado

        // System.out.println("nao funciona");

        // } else {

        // System.out.println("Comando inválido!");

        // }
        jogo.processarComando(comando);
    }

    public void mudarInterface() {
        // falta implementar
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
