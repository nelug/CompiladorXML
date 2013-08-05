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
public class GeneradorFlex {
    public static void main(String[] args) {
        JFlex.Main.generate(new File(
                "src"+File.separator+"clasesPrograma"
                + File.separator + "Lexico.flex"));
    }

}
