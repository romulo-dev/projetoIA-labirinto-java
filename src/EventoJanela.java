/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobuscaestrela;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author windows rsr
 */
public class EventoJanela extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
    
}
