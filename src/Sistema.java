package projetobuscaestrela;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
//import Painel.PanelFrame;
import PanelFrame;

/**
 *
 * @author windows rsr
 */
public class Sistema {

    static ArrayList<No> priorityfila = new ArrayList<No>();
    static PriorityQueue<No> fila = new PriorityQueue<>();
    static ArrayList<No> l = new ArrayList<>();
    static ArrayList<Posicao> solucoes1 = new ArrayList<>();
    static Posicao[] solucoes;

    void adicionaNo(No no) {
        fila.add(no);
    }

    public static boolean EObjetivo(No E, Posicao posicaofinal) {
        if (E.p.getI() == posicaofinal.getI() && E.p.getJ() == posicaofinal.getJ()) {
            return true;
        }
        return false;
    }

    static boolean verificaFila(PriorityQueue<No> fila, Posicao po) {
        for (No op : fila) {
            if (op.p.getI() == po.getI() && op.p.getJ() == po.getJ()) {
                return true;
            }

        }
        return false;
    }

    static boolean verificaFilaAvaliacao(PriorityQueue<No> fila, Posicao po, Posicao posicaoFinal, No nopai) {
        //int h=op.
        for (No op : fila) {
            if (nopai.custo + 1 + Sistema.dm(po, posicaoFinal) == op.funcaoavaliacao) {
                return true;
            }
        }
        return false;
    }

    public static boolean gerasucessores(No e, int matriz[][], Posicao pfinal, PriorityQueue fila) {
        Posicao pnova = new Posicao(e.p.getI(), e.p.getJ() + 1);

        if (pnova.getJ() < matriz[0].length && matriz[pnova.getI()][pnova.getJ()] == 1 && verificaFila(fila, pnova) == false) {
            //System
            No estadonovo = new No(e.custo + 1, dm(pnova, pfinal), pnova, l.size() - 1);
            fila.add(estadonovo);
        }
        pnova = new Posicao(e.p.getI() - 1, e.p.getJ());
        if (pnova.getI() > -1 && matriz[pnova.getI()][pnova.getJ()] == 1 && verificaFila(fila, pnova) == false) {
            System.out.println("");
            No estadonovo = new No(e.custo + 1, dm(pnova, pfinal), pnova, l.size() - 1);
            fila.add(estadonovo);
        }
        pnova = new Posicao(e.p.getI() + 1, e.p.getJ());
        if (pnova.getI() < matriz.length && matriz[pnova.getI()][pnova.getJ()] == 1 && verificaFila(fila, pnova) == false) {
            No estadonovo = new No(e.custo + 1, dm(pnova, pfinal), pnova, l.size() - 1);
            fila.add(estadonovo);
        }
        pnova = new Posicao(e.p.getI(), e.p.getJ() - 1);
        if (pnova.getJ() > -1 && matriz[pnova.getI()][pnova.getJ()] == 1 && verificaFila(fila, pnova) == false) {
            No estadonovo = new No(e.custo + 1, dm(pnova, pfinal), pnova, l.size() - 1);
            fila.add(estadonovo);
        }
        return false;
    }

    static void imprimeCaminho(ArrayList<No> l) {
        No e = l.get(l.size() - 1);
        System.out.println("tamanho de l:" + l.size());
        System.out.println("Listas de posições para chegar ao resultado");
        System.out.println(e.p);
        Sistema.solucoes1.add(e.p);
        while (e.pai != -1) {
            e = l.get(e.pai);
            Sistema.solucoes1.add(e.p);
            System.out.println(e.p);
        }
        Sistema.solucoes = new Posicao[Sistema.solucoes1.size()];

    }

    static int dm(Posicao posicaoaatual, Posicao pfinal) {
        return Math.abs(posicaoaatual.getI() - pfinal.getI()) + Math.abs(pfinal.getJ() - posicaoaatual.getJ());
    }

    static void instanciaMatriz(int matriz[][], int tamanholinha, int tamanhoColuna) {
        for (int i = 0; i < tamanholinha; i++) {
            for (int j = 0; j < tamanhoColuna; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    static int matrizLabirinto[][];
    static int nlinha;
    static int ncoluna;
    static int vetor[] = new int[2];
    static int vetorPosicaoInicial[] = new int[2];
    static int vetorPosicaoFinal[] = new int[2];

    static void lerArquivo(String nomedoArquivo) {
        try {
            FileReader arquivo = new FileReader(nomedoArquivo);
            BufferedReader file = new BufferedReader(arquivo);
            String string;
            int indice = 0;
            int indiceVetorPosicaoInicial = 0;
            int indiceVetorPosicaoFinal = 0;
            int numeroLinhas = 0;
            int i = 0;
            boolean condicao = false;
            //int j=0;
            while ((string = file.readLine()) != null) {
                Scanner scanner;
                if (numeroLinhas <= 2) {
                    scanner = new Scanner(string).useDelimiter(" ");
                    while (scanner.hasNext()) {
                        if (numeroLinhas == 0) {
                            vetor[indice] = Integer.parseInt(scanner.next());
                            if (indice == 1) {
                                //System.out.println("Executou aqui");    
                                matrizLabirinto = new int[vetor[0]][vetor[1]];
                                instanciaMatriz(matrizLabirinto, vetor[0], vetor[1]);
                            }
                            indice = indice + 1;
                        }
                        if (numeroLinhas == 1) {
                            System.out.println("executou o numerolinhas==1");
                            vetorPosicaoInicial[indiceVetorPosicaoInicial] = scanner.nextInt();
                            indiceVetorPosicaoInicial = indiceVetorPosicaoInicial + 1;
                            System.out.println("numero de linhas no executou o numerolinhas==1");
                        }
                        if (numeroLinhas == 2) {
                            System.out.println("executou o numeroslinhas==2");
                            vetorPosicaoFinal[indiceVetorPosicaoFinal] = scanner.nextInt();
                            indiceVetorPosicaoFinal = indiceVetorPosicaoFinal + 1;

                        }
                    }
                    numeroLinhas = numeroLinhas + 1;
                    System.out.println("numerolinhas:" + numeroLinhas);
                    //continue;
                } else if (numeroLinhas > 2) {
                    int j = 0;
                    while ((j != string.length())) {
                        //System.out.println("valor da string:"+string.charAt(j));    
                        matrizLabirinto[i][j] = Integer.parseInt(string.charAt(j) + "");
                        System.out.println("valor de matrizlabirinto[" + i + "][" + j + "]:" + matrizLabirinto[i][j]);
                        j++;
                    }
                    i++;
                }
            }

            arquivo.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura");
        }
    }
    private static JFrame frame = new JFrame("Jogo da Velha");

    public static void main(String[] args) {
        Sistema.lerArquivo("C:\\Users\\windows rsr\\Documents\\NetBeansProjects\\projetoIA\\src\\projetobuscaestrela\\arqlabirinto.txt");
        Posicao posicaofinal = new Posicao(vetorPosicaoFinal[0], vetorPosicaoFinal[1]);
        for (int k = 0; k < matrizLabirinto.length; k++) {
            System.out.println();
            for (int w = 0; w < matrizLabirinto[k].length; w++) {
                System.out.print("" + matrizLabirinto[k][w]);
            }

        }

        fila.add(new No(0, dm(new Posicao(vetorPosicaoInicial[0], vetorPosicaoInicial[1]), posicaofinal), new Posicao(vetorPosicaoInicial[0], vetorPosicaoInicial[1]), -1));
        while (!fila.isEmpty()) {
            No E = fila.remove();
            System.out.println("Posicao:" + E.p.getI() + "," + E.p.getJ());
            l.add(E);
            if (Sistema.EObjetivo(E, posicaofinal) == true) {
                break;
            } else {
                gerasucessores(E, matrizLabirinto, posicaofinal, fila);
            }
            for (No op : fila) {
                System.out.println(op.funcaoavaliacao + " " + op.p.toString());
            }
        }
        Sistema.imprimeCaminho(l);
        Collections.reverse(Sistema.solucoes1);

        for (int i = 0; i < Sistema.solucoes1.size(); i++) {
            Sistema.solucoes[i] = Sistema.solucoes1.get(i);
        }

        PanelFrame.solucoes = Sistema.solucoes;
        PanelFrame.posicaoInicial = 1;
        PanelFrame panelFrame = new PanelFrame(matrizLabirinto.length, matrizLabirinto[0].length, matrizLabirinto, vetorPosicaoInicial[0], vetorPosicaoInicial[1]);
        panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelFrame.setSize(1000, 700);
        panelFrame.setVisible(true);

    }

}
