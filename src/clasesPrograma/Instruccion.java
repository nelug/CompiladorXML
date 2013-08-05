/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesPrograma;

/**
 *
 * @author Chejo
 */
public class Instruccion {
    //esta clase sirve para guardar los datos de cada una de las intrucciones
    String instruccion;//guarda el nombre de la instruccion: linea, circulo, rectangulo, color
    int[] numeros;//guarda los numeros correspondientes de cada instruccion

    public Instruccion() {
    }

    public Instruccion(String instruccion, int[] numeros) {
        this.instruccion = instruccion;
        this.numeros = numeros;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
