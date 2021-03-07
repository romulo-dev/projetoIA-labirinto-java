/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import projetobuscaestrela.Posicao;

/**
 *
 * @author windows rsr
 */
public class Painel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vetore[][] = {{1, 0, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {1, 0, 0, 1, 0},
        {1, 1, 1, 1, 1}
        };
        Posicao posicoes[] = {
            new Posicao(0, 0), new Posicao(1, 0), new Posicao(2, 0), new Posicao(3, 0), new Posicao(3, 1), new Posicao(3, 2), new Posicao(3, 3),
            new Posicao(2, 3), new Posicao(1, 3), new Posicao(1, 4), new Posicao(0, 4)

        };
        PanelFrame.solucoes = posicoes;
        PanelFrame.posicaoInicial = 1;
        for (Posicao l : PanelFrame.solucoes) {
            System.out.println("" + l.getI());
        }
        PanelFrame panelFrame = new PanelFrame(4, 5, vetore, 0, 0);

        panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelFrame.setSize(1000, 700);
        panelFrame.setVisible(true);
    }

}
