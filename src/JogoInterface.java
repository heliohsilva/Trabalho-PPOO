
//@author iara
import javax.swing.*;
import java.awt.*;

public class JogoInterface {
    private JFrame frame;
    private JLabel label;
    private JLabel imgLabel;

    public JogoInterface() {
        frame = new JFrame("Fundação Terra");
        label = new JLabel("Fundação Terra", SwingConstants.CENTER);
        imgLabel = new JLabel("", SwingConstants.CENTER);

        montarFrame(); // monta frame
    }

    private void montarFrame() {
        configurarLabel();
        configurarImagem();

        frame.setSize(600, 500); // define um tamanho para o frame
        frame.setLayout(new GridLayout(3, 1));// coloca como flow layout
        frame.pack(); // monta o layout
    }

    private void configurarLabel() {
        frame.add(label);// adicione o rótulo ao conteúdo do frame
        label.setFont(new Font("Arial", Font.BOLD, 28)); // ajustar o tamanho da fonte
    }

    private void configurarImagem() {
        ImageIcon imagemIcon = new ImageIcon("../img/sistemaSolar.jpg");
        imgLabel.setIcon(imagemIcon);
        frame.add(imgLabel);
    }

    public void exibir() {
        frame.setVisible(true);
    }
}