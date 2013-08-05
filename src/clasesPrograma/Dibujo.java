/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesPrograma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * 
 *
 * @author Chejo
 */
public class Dibujo extends JPanel {
    //clase en la que se dibujan las figuras
    ArrayList<Instruccion> instrucciones;//istrucciones que se van a ejecutar

    public Dibujo(ArrayList<Instruccion> instrucciones) {
        this.instrucciones=instrucciones;
    }
    
    /*
     * clase que se encarga de comparar el nombre de la instruccion y dibujar la figura correspondiente
     */
    private void dibujarForma(Graphics g, Instruccion instruccion){
        switch(instruccion.getInstruccion()){
            case "linea":
                g.drawLine(instruccion.numeros[0], instruccion.numeros[1], instruccion.numeros[2], instruccion.numeros[3]);
                break;
            case "rectangulo":
                g.drawRect(instruccion.numeros[0], instruccion.numeros[1], instruccion.numeros[2], instruccion.numeros[3]);
                break;  
            case "circulo":
                g.drawOval(instruccion.numeros[0], instruccion.numeros[1], instruccion.numeros[2], instruccion.numeros[2]);
                break;
            case "color":
                g.setColor(new Color(instruccion.numeros[0], instruccion.numeros[1], instruccion.numeros[2]));
                break;
        }
    }  

    @Override
    public void paintComponent( Graphics g )
    {
        //metodo sobrecargado para que se pueda dibujar
        super.paintComponent(g);
        this.setBackground( Color.WHITE );
        for(int i=0; i<instrucciones.size(); i++) {
            dibujarForma(g,instrucciones.get(i));
        }
    }
}
