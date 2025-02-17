/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobuscaestrela;

/**
 *
 * @author windows rsr
 */
abstract class AbstractNo implements Comparable<Object> {

    int heuristica;
    int custo;
    int funcaoavaliacao;
    Posicao p;
    int pai;

    public AbstractNo(int custo, int heuristica, Posicao p, int pai) {
        this.custo = custo;
        this.heuristica = heuristica;
        this.funcaoavaliacao = custo+heuristica;
        this.p = p;
        this.pai=pai;
    }

    @Override
    public int compareTo(Object t) {
        if (this.funcaoavaliacao > ((No) t).funcaoavaliacao) {
            return 1;
        } else if (this.funcaoavaliacao < ((No) t).funcaoavaliacao) {
            return -1;
        }
        return 0;

    }
}
