/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import clasesPrograma.AnalizadorLexico;
import clasesPrograma.AnalizadorSintactico;
import clasesPrograma.Dibujo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Inter-Linux
 */
public class Muestra extends javax.swing.JFrame {

    /**
     * Creates new form Muestra
     */
     Graphics g; 
    Dibujo panelDibujo;
    JEditorPane areacodigo;
    public Muestra(JEditorPane codigo) {
        areacodigo=codigo;
        initComponents();
        ejecutar();
        
    }
    public Muestra() {
        
    }

    
     public void ejecutar(){
    try{       
           
            escribir("programa.txt");//se guarda en un archivo externo lo que se escribio
            AnalizadorLexico lex = new AnalizadorLexico(new FileReader("programa.txt"));//se le pasa al analizador lexico lo que se escribio
            AnalizadorSintactico parser = new AnalizadorSintactico(lex);//se le pasa al analizador sitactico lo que genero el analizador lexico
            try{
                parser.parse();
             
                panelDibujo = new Dibujo(parser.getInstrucciones());//se le pasan las figuras que se deben dibujar
                panelDibujo.setBackground( Color.white );
                panelDibujo.setLocation(5, 10);
                final Container content = this.getContentPane();
                content.setLayout(new BorderLayout());
                content.add(panelDibujo);
                panelDibujo.setVisible(true);
            //    panel.repaint(0, 0, this.panel.getWidth(), this.panel.getHeight());
             
                // agrega el panel al marco 
                
            }
            catch (java.lang.Exception el)
            {
                 JOptionPane.showConfirmDialog(this, "error encontrado: "+el.getMessage());
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
    public void escribir(String direccion){
        //metodo que guarda lo que esta escrito en un archivo de texto
	try{	
            FileWriter writer = new FileWriter(direccion);
            PrintWriter print = new PrintWriter(writer);
            print.print(areacodigo.getText());
            writer.close();
	}
            catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
     private void imagen(JPanel unaVentana,File url,String id){
        File fichero = new File(url+"/"+id+".jpg");
		String formato = "jpg";

		// Creamos la imagen para dibujar en ella.
		BufferedImage imagen = new BufferedImage((unaVentana.getWidth()+0),
				(unaVentana.getHeight()+0), BufferedImage.TYPE_INT_RGB);

		// Hacemos el dibujo
		Graphics g = imagen.getGraphics();
		unaVentana.paint(g);

		// Escribimos la imagen en el archivo.
		try {
			ImageIO.write(imagen, formato, fichero);
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        GuardarImagen = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMenu1.setText("File                            ");

        GuardarImagen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        GuardarImagen.setText("Guardar Imagen");
        GuardarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarImagenActionPerformed(evt);
            }
        });
        jMenu1.add(GuardarImagen);

        Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Salir);

        jMenuBar1.add(jMenu1);

        exit.setText("              Salir              ");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jMenuBar1.add(exit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarImagenActionPerformed

        String name = JOptionPane.showInputDialog("Ingrese el nombre dels Imagen a guardar");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter("Carpeta de archivos","doc") );;
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION){
            //obtiene ruta y nombre del archivo
            if(name.isEmpty()){
                name="imagen";
            }
            this.imagen(panelDibujo,fileChooser.getSelectedFile(),name);
            JOptionPane.showMessageDialog(fileChooser, "Imagen Guardada Con Exito");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarImagenActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed

        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked

        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Muestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Muestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Muestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Muestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Muestra().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GuardarImagen;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
