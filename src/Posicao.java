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
public class Posicao {
    private int i;
    private int j;

    public Posicao(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    
    
    @Override
    public String toString() {
        return "("+this.i+","+this.j+")";
    }
  
    
}
