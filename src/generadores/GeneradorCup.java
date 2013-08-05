/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import java.io.File;

/**
 *
 * @author Chejo
 */
public class GeneradorCup {
     public static void main(String[] args) {
        String opciones[] = new String[5];
        opciones[0]="-destdir";
        opciones[1]="src"
                +File.separator+
                "clasesPrograma";
        opciones[2]="-parser";
        opciones[3]="AnalizadorSintactico";
        opciones[4]="src"
                +File.separator+
                "clasesPrograma"
                +File.separator+
                "Sintactico.cup";
        try {
            java_cup.Main.main(opciones);
            }
        catch (Exception e) {
            System.out.print(e);
            }
    }

}
