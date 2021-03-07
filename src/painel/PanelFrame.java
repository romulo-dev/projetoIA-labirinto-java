package painel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.*;
import java.io.*;
import static javafx.scene.CacheHint.SCALE;
import javafx.scene.layout.Border;
import javafx.scene.transform.Scale;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import projetobuscaestrela.Posicao;
//import projetobuscaestrela.Sistema;

/**
 *
 * @author windows rsr
 */
public class PanelFrame extends JFrame {

    private final JPanel buttonJPanel; // painel para armazenar botões
    private final JPanel telacima;
    public int numeroLinhas;
    int numeroColunas;
    int matriz[][];
    public JButton botao1 = new JButton("caminhar");
    public static Posicao solucoes[];
    public static int posicaoInicial;

    private JLabel[][] label;

    public PanelFrame(int numeroLinhas, int numeroColunas, int matriz[][], int linhaInicial, int colunaInicial) {
        super("Panel Demo");
        label = new JLabel[numeroLinhas][numeroColunas];
        buttonJPanel = new JPanel();
        buttonJPanel.setSize(1000, 350);
        telacima = new JPanel();
        telacima.setSize(1000, 350);
        buttonJPanel.setLayout(new GridLayout(numeroLinhas, numeroColunas, 1, 1));
        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.BLACK);

        ImageIcon img3 = new ImageIcon("C:/Users/windows rsr/Documents/NetBeansProjects/Painel/src/pessoa-labirinto8.jpg");

        for (int count = 0; count < numeroLinhas; count++) {

            for (int j = 0; j < numeroColunas; j++) {

                ImageIcon img = new ImageIcon("C:/Users/windows rsr/Documents/NetBeansProjects/Painel/src/preto.png");
                ImageIcon img2 = new ImageIcon("C:/Users/windows rsr/Documents/NetBeansProjects/Painel/src/branco.png");

                if (matriz[count][j] == 1) {
                    label[count][j] = new JLabel(img2);
                    label[count][j].setIcon(new ImageIcon(img2.getImage().getScaledInstance(1000, 350 / numeroLinhas, Image.SCALE_DEFAULT)));
                    buttonJPanel.add(label[count][j]);
                    label[count][j].setBorder(line);

                }
                if (matriz[count][j] == 0) {
                    label[count][j] = new JLabel(img);
                    label[count][j].setIcon(new ImageIcon(img.getImage().getScaledInstance(1000, 350 / numeroLinhas, Image.SCALE_DEFAULT)));
                    buttonJPanel.add(label[count][j]);
                    label[count][j].setBorder(line);
                }
            }
        }
        this.label[linhaInicial][colunaInicial].setIcon(new ImageIcon(img3.getImage().getScaledInstance(1000 / numeroColunas, 350 / numeroLinhas, Image.SCALE_DEFAULT))); // 2° parametro divide pelo numero de linhas
        // a imagem deve ter 1000/numeroColunas X 350/numeroLinhas pixeis
        add(buttonJPanel, BorderLayout.SOUTH); // adiciona painel ao JFrame
        add(telacima, BorderLayout.NORTH);
        telacima.add(botao1);

        botao1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {

                if (posicaoInicial == PanelFrame.solucoes.length) {
                    return;
                }
                PanelFrame tela1 = new PanelFrame(numeroLinhas, numeroColunas, matriz, PanelFrame.solucoes[posicaoInicial].getI(), PanelFrame.solucoes[posicaoInicial].getJ());
                //tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tela1.setSize(1000, 700);
                tela1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
                tela1.setVisible(true);
                posicaoInicial++;

            }
        });

    }

    public Icon getLabel(int i, int j) {
        return label[i][j].getIcon();
    }

    public void setLabel(int i, int j) {

        PanelFrame tela = new PanelFrame(this.numeroLinhas, this.numeroColunas, this.matriz, i, j);

    }

}
