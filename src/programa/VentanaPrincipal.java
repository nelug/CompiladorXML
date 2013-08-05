
package programa;

import clasesPrograma.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.edisoncor.gui.comboBox.ComboBoxRound;


/**
 *
 * @author Chejo
 */
public class VentanaPrincipal extends javax.swing.JFrame {


    Graphics g; 
    Dibujo panelDibujo;
    String color;
    public VentanaPrincipal() {
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"ERROR   " +ex);
            }
        }
        //this.setUndecorated(true);
        initComponents(); 
        this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
       // areainterna.setSize(this.contenedor.getWidth(), this.contenedor.getHeight());   
    }
    
    private void imagen(JInternalFrame unaVentana){
        File fichero = new File("foto.jpg");
		String formato = "jpg";
		// Creamos la imagen para dibujar en ella.
		BufferedImage imagen = new BufferedImage(unaVentana.getContentPane().getWidth(),
				unaVentana.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);
		// Hacemos el dibujo
		Graphics g = imagen.getGraphics();
		unaVentana.getContentPane().paint(g);
		// Escribimos la imagen en el archivo.
		try {
			ImageIO.write(imagen, formato, fichero);
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
    }
    
    public void ejecutar(){
    try{       
           
            escribir("programa.txt");//se guarda en un archivo externo lo que se escribio
            AnalizadorLexico lex = new AnalizadorLexico(new FileReader("programa.txt"));//se le pasa al analizador lexico lo que se escribio
            AnalizadorSintactico parser = new AnalizadorSintactico(lex);//se le pasa al analizador sitactico lo que genero el analizador lexico
            try{
                JInternalFrame marco;
             
                JPanel panelOP=new JPanel();
                JButton guardar=new JButton();
                guardar.setText("Guardar");
                guardar.setVisible(true);
                panelOP.add(guardar);
                panelOP.setVisible(true);
                final Container content = this.getContentPane();
                content.setLayout(new BorderLayout());
                
                parser.parse();
                marco = new JInternalFrame();
      
                panelDibujo = new Dibujo(parser.getInstrucciones());//se le pasan las figuras que se deben dibujar
                panelDibujo.setBackground( Color.white );
                panelDibujo.setLocation(5, 10);
                panelDibujo.add(guardar,BorderLayout.AFTER_LAST_LINE);
                marco.add(panelDibujo); 
                guardar.setLocation(100,30);
                // agrega el panel al marco 
//                contenedor.add(marco);
                marco.setClosable(true);
                marco.setIconifiable(true);
                marco.setMaximizable(true);
                marco.setSize(500,500);
                marco.setVisible(true);
                guardar.setSize(80, 30);
                guardar.setVisible(true);// establece el tamaño del marco
                //metodo para guardar la imagen
               // this.imagen(marco);
               
                // muestra el marco
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pmenu = new javax.swing.JPopupMenu();
        ejecutar = new javax.swing.JMenuItem();
        insesrtar = new javax.swing.JMenu();
        circ = new javax.swing.JMenuItem();
        rect = new javax.swing.JMenuItem();
        lin = new javax.swing.JMenuItem();
        colr = new javax.swing.JMenuItem();
        LimpiarArea = new javax.swing.JMenuItem();
        Abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        panelopciones = new javax.swing.JPanel();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        jToolBar3 = new javax.swing.JToolBar();
        abrirbtt = new javax.swing.JButton();
        nuevobtt = new javax.swing.JButton();
        guardarbtt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ejecutarbtt = new javax.swing.JButton();
        documentation = new javax.swing.JButton();
        autours = new javax.swing.JButton();
        herramientas = new javax.swing.JPanel();
        txtcolor = new org.edisoncor.gui.comboBox.ComboBoxRound();
        colorbtt = new org.edisoncor.gui.button.ButtonTask();
        lineabtt = new org.edisoncor.gui.button.ButtonTask();
        rectangulobtt = new org.edisoncor.gui.button.ButtonTask();
        circulobtt = new org.edisoncor.gui.button.ButtonTask();
        jScrollPane2 = new javax.swing.JScrollPane();
        areacodigo = new javax.swing.JEditorPane();
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        abrirp = new javax.swing.JMenuItem();
        nuevop = new javax.swing.JMenuItem();
        guardarp = new javax.swing.JMenuItem();
        salirp = new javax.swing.JMenuItem();
        view = new javax.swing.JMenu();
        bopciones = new javax.swing.JCheckBoxMenuItem();
        bherramientas = new javax.swing.JCheckBoxMenuItem();
        herramient = new javax.swing.JMenu();
        hcirculo = new javax.swing.JMenuItem();
        hlinea = new javax.swing.JMenuItem();
        hrectangulo = new javax.swing.JMenuItem();
        hcolor = new javax.swing.JMenuItem();
        option = new javax.swing.JMenu();
        oejecutar = new javax.swing.JMenuItem();
        odocumentacion = new javax.swing.JMenuItem();
        oautores = new javax.swing.JMenuItem();
        blanco = new javax.swing.JMenu();
        exit = new javax.swing.JMenu();

        ejecutar.setText("Ejecutar Proyecto");
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });
        Pmenu.add(ejecutar);

        insesrtar.setText("Insertar");

        circ.setText("Insertar Circulo");
        circ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circActionPerformed(evt);
            }
        });
        insesrtar.add(circ);

        rect.setText("Insertar Rectangulo");
        rect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectActionPerformed(evt);
            }
        });
        insesrtar.add(rect);

        lin.setText("Insertar Linea");
        lin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linActionPerformed(evt);
            }
        });
        insesrtar.add(lin);

        colr.setText("Insertar Color");
        colr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colrActionPerformed(evt);
            }
        });
        insesrtar.add(colr);

        Pmenu.add(insesrtar);

        LimpiarArea.setText("Limpiar Area");
        LimpiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarAreaActionPerformed(evt);
            }
        });
        Pmenu.add(LimpiarArea);

        Abrir.setText("Abrir Proyecto");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Pmenu.add(Abrir);

        Guardar.setText("Guardar Proyecto");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        Pmenu.add(Guardar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador XML");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        panelopciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        panelopciones.setToolTipText("Barra de Opciones");

        panelShadow1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setToolTipText("Barra de Opciones");

        abrirbtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_open (2).png"))); // NOI18N
        abrirbtt.setText("                      ");
        abrirbtt.setToolTipText("Abrir Proyecto");
        abrirbtt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirbtt.setBorderPainted(false);
        abrirbtt.setContentAreaFilled(false);
        abrirbtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirbtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirbttActionPerformed(evt);
            }
        });
        jToolBar3.add(abrirbtt);

        nuevobtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_new.png"))); // NOI18N
        nuevobtt.setText("                      ");
        nuevobtt.setToolTipText("Nuevo Proyecto");
        nuevobtt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nuevobtt.setBorderPainted(false);
        nuevobtt.setContentAreaFilled(false);
        nuevobtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevobtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevobttActionPerformed(evt);
            }
        });
        jToolBar3.add(nuevobtt);

        guardarbtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        guardarbtt.setText("                      ");
        guardarbtt.setToolTipText("Guardar Proyecto");
        guardarbtt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        guardarbtt.setBorderPainted(false);
        guardarbtt.setContentAreaFilled(false);
        guardarbtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarbtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarbttActionPerformed(evt);
            }
        });
        jToolBar3.add(guardarbtt);

        jLabel1.setText("                                            ");
        jToolBar3.add(jLabel1);

        ejecutarbtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ejecutar.png"))); // NOI18N
        ejecutarbtt.setText("                      ");
        ejecutarbtt.setToolTipText("Ejecutar Proyecto");
        ejecutarbtt.setBorderPainted(false);
        ejecutarbtt.setContentAreaFilled(false);
        ejecutarbtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ejecutarbtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarbttActionPerformed(evt);
            }
        });
        jToolBar3.add(ejecutarbtt);

        documentation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product_documentation.png"))); // NOI18N
        documentation.setText("                      ");
        documentation.setToolTipText("Ver Documentacion");
        documentation.setBorderPainted(false);
        documentation.setContentAreaFilled(false);
        documentation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        documentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentationActionPerformed(evt);
            }
        });
        jToolBar3.add(documentation);

        autours.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/text_x_authors.png"))); // NOI18N
        autours.setText("                      ");
        autours.setToolTipText("Ver Autores");
        autours.setContentAreaFilled(false);
        autours.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        autours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoursActionPerformed(evt);
            }
        });
        jToolBar3.add(autours);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelopcionesLayout = new javax.swing.GroupLayout(panelopciones);
        panelopciones.setLayout(panelopcionesLayout);
        panelopcionesLayout.setHorizontalGroup(
            panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelopcionesLayout.setVerticalGroup(
            panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelopcionesLayout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        herramientas.setBorder(javax.swing.BorderFactory.createTitledBorder("Herramientas"));
        herramientas.setToolTipText("Barra de Herramientas");

        txtcolor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Azul", "Aqua", "Amarillo", "Anaranjado", "Celeste", "Cafes", "Fusia", "Gris", "Morado", "Verde", "Verde Claro", "Rojo", "Rosado" }));
        txtcolor.setToolTipText("Seleccione Color ");
        txtcolor.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        colorbtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paint.png"))); // NOI18N
        colorbtt.setText("Color");
        colorbtt.setToolTipText("Insertar Color");
        colorbtt.setCategorySmallFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N
        colorbtt.setDescription("( 0 ,  0 ,  0 )");
        colorbtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorbttActionPerformed(evt);
            }
        });

        lineabtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/linea.png"))); // NOI18N
        lineabtt.setText("Linea");
        lineabtt.setToolTipText("Insertar Linea");
        lineabtt.setCategorySmallFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N
        lineabtt.setDescription("( x,  y,  largo, angulo )");
        lineabtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineabttActionPerformed(evt);
            }
        });

        rectangulobtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadro.png"))); // NOI18N
        rectangulobtt.setText("Rectangulo");
        rectangulobtt.setToolTipText("Insertar Rectangulo");
        rectangulobtt.setCategoryFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rectangulobtt.setCategorySmallFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N
        rectangulobtt.setDescription("( x , y , Base , Altura )");
        rectangulobtt.setMaximumSize(new java.awt.Dimension(128, 50));
        rectangulobtt.setMinimumSize(new java.awt.Dimension(128, 50));
        rectangulobtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangulobttActionPerformed(evt);
            }
        });

        circulobtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo.png"))); // NOI18N
        circulobtt.setText("Circulo");
        circulobtt.setToolTipText("Insertar Circulo");
        circulobtt.setCategoryFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        circulobtt.setCategorySmallFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N
        circulobtt.setDescription("( x , y , Radio )");
        circulobtt.setMaximumSize(new java.awt.Dimension(128, 50));
        circulobtt.setMinimumSize(new java.awt.Dimension(128, 50));
        circulobtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circulobttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout herramientasLayout = new javax.swing.GroupLayout(herramientas);
        herramientas.setLayout(herramientasLayout);
        herramientasLayout.setHorizontalGroup(
            herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, herramientasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtcolor, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(colorbtt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(lineabtt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(rectangulobtt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(circulobtt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        herramientasLayout.setVerticalGroup(
            herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(herramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(circulobtt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rectangulobtt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lineabtt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(colorbtt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        areacodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Editor XML"));
        areacodigo.setToolTipText("");
        areacodigo.setFocusTraversalPolicyProvider(true);
        areacodigo.setInheritsPopupMenu(true);
        areacodigo.setName(""); // NOI18N
        areacodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                areacodigoMousePressed(evt);
            }
        });
        areacodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areacodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areacodigoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(areacodigo);

        menu.setToolTipText("Barra de Menu");
        menu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                menuKeyReleased(evt);
            }
        });

        file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/documents_settings_folder.png"))); // NOI18N
        file.setText("                                          ");
        file.setToolTipText("File");
        file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        file.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        abrirp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        abrirp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_open (2).png"))); // NOI18N
        abrirp.setText("Abrir Proyecto");
        abrirp.setToolTipText("Abrir Proyecto");
        abrirp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirpActionPerformed(evt);
            }
        });
        file.add(abrirp);

        nuevop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_new.png"))); // NOI18N
        nuevop.setText("Nuevo Projecto");
        nuevop.setToolTipText("Nuevo Projecto");
        nuevop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevopActionPerformed(evt);
            }
        });
        file.add(nuevop);

        guardarp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        guardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        guardarp.setText("Guardar");
        guardarp.setToolTipText("Guardar Proyecto");
        guardarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarpActionPerformed(evt);
            }
        });
        file.add(guardarp);

        salirp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        salirp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        salirp.setText("Salir");
        salirp.setToolTipText("Salir del Compilador");
        salirp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirpActionPerformed(evt);
            }
        });
        file.add(salirp);

        menu.add(file);

        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_choose.png"))); // NOI18N
        view.setText("                                          ");
        view.setToolTipText("Opciones de Barras");
        view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        view.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bopciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        bopciones.setSelected(true);
        bopciones.setText("Barra de Opciones");
        bopciones.setToolTipText("Ver Barra de Opciones");
        bopciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bopcionesMouseClicked(evt);
            }
        });
        view.add(bopciones);

        bherramientas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        bherramientas.setSelected(true);
        bherramientas.setText("Barra de Herramientas");
        bherramientas.setToolTipText("Ver Barra de Herramientas");
        bherramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bherramientasMouseClicked(evt);
            }
        });
        view.add(bherramientas);

        menu.add(view);

        herramient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/advancedsettings.png"))); // NOI18N
        herramient.setText("                                          ");
        herramient.setToolTipText("Opciones de Herramientas");
        herramient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        herramient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        hcirculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        hcirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo.png"))); // NOI18N
        hcirculo.setText("Insertar Circulo");
        hcirculo.setToolTipText("Insertar Circulo");
        hcirculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcirculoActionPerformed(evt);
            }
        });
        herramient.add(hcirculo);

        hlinea.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        hlinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/linea.png"))); // NOI18N
        hlinea.setText("Insertar Linea");
        hlinea.setToolTipText("Insertar Linea");
        hlinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hlineaActionPerformed(evt);
            }
        });
        herramient.add(hlinea);

        hrectangulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        hrectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadro.png"))); // NOI18N
        hrectangulo.setText("Insertar Rectangulo");
        hrectangulo.setToolTipText("Insertar Rectangulo");
        hrectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrectanguloActionPerformed(evt);
            }
        });
        herramient.add(hrectangulo);

        hcolor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        hcolor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paint.png"))); // NOI18N
        hcolor.setText("Insertar Color");
        hcolor.setToolTipText("Insertar Color");
        hcolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcolorActionPerformed(evt);
            }
        });
        herramient.add(hcolor);

        menu.add(herramient);

        option.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings1.png"))); // NOI18N
        option.setText("                                          ");
        option.setToolTipText("Menu Opciones");
        option.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        option.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        oejecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        oejecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ejecutar.png"))); // NOI18N
        oejecutar.setText("Ejecutar");
        oejecutar.setToolTipText("Ejecutar Proyecto");
        oejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oejecutarActionPerformed(evt);
            }
        });
        option.add(oejecutar);

        odocumentacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        odocumentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product_documentation.png"))); // NOI18N
        odocumentacion.setText("Documentacion");
        odocumentacion.setToolTipText("Abrir Documentacion");
        odocumentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odocumentacionActionPerformed(evt);
            }
        });
        option.add(odocumentacion);

        oautores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        oautores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/text_x_authors.png"))); // NOI18N
        oautores.setText("Autores");
        oautores.setToolTipText("Mostrar Autores");
        oautores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oautoresActionPerformed(evt);
            }
        });
        option.add(oautores);

        menu.add(option);

        blanco.setText("                                                                                                                                                                                                                                                    ");
        blanco.setEnabled(false);
        menu.add(blanco);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exit.setText("                                          ");
        exit.setDoubleBuffered(true);
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        menu.add(exit);
        exit.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelopciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(herramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(herramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutarbttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarbttActionPerformed
        Muestra ejecuta;
        ejecuta=new Muestra(areacodigo);
        ejecuta.setVisible(true);
    }//GEN-LAST:event_ejecutarbttActionPerformed

    private String LeerArchivo(File f){
        StringBuffer texto=new StringBuffer();
        try {
        int c;
        FileReader entrada=new FileReader(f);
        while((c=entrada.read())!=-1){
        texto.append((char)c);
        }
        }catch (IOException ex) {}
        return texto.toString();
    }
   private void BUSCARarchivo()
    {
      JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileFilter( new FileNameExtensionFilter("Archivo .CXML","CXML") );;
       int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION ){
            //obtiene ruta y nombre del archivo
           areacodigo.setText(LeerArchivo(fileChooser.getSelectedFile()));
        }
    } 

    private void autores()
    {
        JOptionPane.showConfirmDialog(null, "Autores\n\n"
            + "Leonel Alberto Madrid Franco  1190-11-8687\n" +
            "Jorge Antonio Laj Guerra         1190-11-9902\n" +
            "Abdiel David Fajardo Armas    1190-11-3464\n" +
            "Carla Mariza Cacao Cabrera    1190-11-2575\n" +
            "Delmer Aníbal Picen Orellana  1390-10-5688");
    }
    private void documentacion(){
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "documentacion.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void escribirAR(File f,String name){
        //metodo que guarda lo que esta escrito en un archivo de texto
	try{	
            FileWriter writer = new FileWriter(f+"/"+name+".CXML");
            PrintWriter print = new PrintWriter(writer);
            print.print(areacodigo.getText());
            writer.close();
	}
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
   

    private void nuevobttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevobttActionPerformed
        this.areacodigo.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevobttActionPerformed

    private void salirpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirpActionPerformed

        System.exit(1);// TODO add your handling code here:
    }//GEN-LAST:event_salirpActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
       
        System.exit(1);// TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked

    private void oejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oejecutarActionPerformed
        Muestra ejecuta;
        ejecuta=new Muestra(areacodigo);
        ejecuta.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_oejecutarActionPerformed

    private void odocumentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odocumentacionActionPerformed

        this.documentacion();// TODO add your handling code here:
    }//GEN-LAST:event_odocumentacionActionPerformed

    private void oautoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oautoresActionPerformed

        this.autores();// TODO add your handling code here:
    }//GEN-LAST:event_oautoresActionPerformed

    private void nuevopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevopActionPerformed

        this.areacodigo.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevopActionPerformed

    private void abrirpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirpActionPerformed

        this.BUSCARarchivo();
        // TODO add your handling code here:
    }//GEN-LAST:event_abrirpActionPerformed

    private void bopcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bopcionesMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_bopcionesMouseClicked

    private void bherramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bherramientasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bherramientasMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

        if(this.bopciones.isSelected()==true){
        this.panelopciones.setVisible(true);
        }
        else  if(this.bopciones.isSelected()==false){
        this.panelopciones.setVisible(false);
        }
        if(this.bherramientas.isSelected()==true){
        this.herramientas.setVisible(true);
        }
        else  if(this.bherramientas.isSelected()==false){
        this.herramientas.setVisible(false);
        }
       
//       areainterna.setSize(this.contenedor.getWidth(), this.contenedor.getHeight());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void guardarproyecto(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del archivo a guardar");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter("Carpeta de archivos","doc") );;
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION){
            //obtiene ruta y nombre del archivo
           this.escribirAR(fileChooser.getSelectedFile(),name);
        }
    }
            
    private void guardarbttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarbttActionPerformed

        this.guardarproyecto();
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarbttActionPerformed

    private void abrirbttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirbttActionPerformed

        this.BUSCARarchivo();
        // TODO add your handling code here:
    }//GEN-LAST:event_abrirbttActionPerformed

    private void guardarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarpActionPerformed

        this.guardarproyecto();// TODO add your handling code here:
    }//GEN-LAST:event_guardarpActionPerformed

    private void circulobttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circulobttActionPerformed
       String datos=areacodigo.getText();
       String param=JOptionPane.showInputDialog(panelopciones,"ingrese los parametros"
               + " Separados por coma\n EJEMPLO: 10,10,10\ntomando en cuenta(x,y,radio)");
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<circulo>("+param+")</circulo>");
        // TODO add your handling code here:
    }//GEN-LAST:event_circulobttActionPerformed

    private void rectangulobttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangulobttActionPerformed

        String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(this.areacodigo,"ingrese los parametros"
               + " Separados por coma\n EJEMPLO: 10,10,10,10\ntomando en cuenta (x,y,base,altura)");
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<rectangulo>("+param+")</rectangulo>");// TODO add your handling code here:
    }//GEN-LAST:event_rectangulobttActionPerformed

    private void lineabttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineabttActionPerformed

        String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(this.areacodigo,"ingrese los parametros"
               + " Separados por coma\n EJEMPLO: 10,10,10,10\ntomando en cuenta (x,y,largo,angulo)");
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<linea>("+param+")</linea>");// TODO add your handling code here:
    // TODO add your handling code here:
    }//GEN-LAST:event_lineabttActionPerformed

    private void colorbttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorbttActionPerformed

        String abrir="<color>",cerrar="</color>";
        this.colores();
        String datos=areacodigo.getText();
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n"+abrir+color+cerrar);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_colorbttActionPerformed

    public static final String[] selectcolor = {"Azul", "Aqua", "Amarillo", "Anaranjado",
    "Celeste","Cafes","Fusia","Gris","Morado","Verde","Verde Claro","Rojo","Rosado"};
    private void hcolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hcolorActionPerformed

        
        JFrame frame = new JFrame("Seleccione Color");
        String ouputcolor = (String) JOptionPane.showInputDialog(frame, 
        "Elije el color Que deseas...."," ",JOptionPane.QUESTION_MESSAGE,null, 
        selectcolor, 
        selectcolor);
        System.out.printf("color %s.\n", ouputcolor);
        this.color=ouputcolor;
        String abrir="<color>",cerrar="</color>";
        this.coloress();
        String datos=areacodigo.getText();
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n"+abrir+color+cerrar);
        // TODO add your handling code here:
    }//GEN-LAST:event_hcolorActionPerformed

    private void hlineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hlineaActionPerformed

          String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(this.areacodigo,"ingrese los parametros"
               + " Separados por coma\n EJEMPLO: 10,10,10,10\ntomando en cuenta (x,y,largo,angulo)");
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<linea>("+param+")</linea>");// TODO add your handling code here:
    }//GEN-LAST:event_hlineaActionPerformed

    private void hrectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrectanguloActionPerformed

         String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(this.areacodigo,"ingrese los parametros"
               + " Separados por coma\n EJEMPLO: 10,10,10,10\ntomando en cuenta (x,y,base,altura)");
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<rectangulo>("+param+")</rectangulo>");// TODO add your handling code here:
    }//GEN-LAST:event_hrectanguloActionPerformed

    private void hcirculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hcirculoActionPerformed

       String datos=areacodigo.getText();
       String param=JOptionPane.showInputDialog(panelopciones,"ingrese los parametros"
               + " Separados por coma\n EJEMPLO: 10,10,10\ntomando en cuenta(x,y,radio)");
        if(datos.isEmpty())
           areacodigo.setText("<XML>");
       else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<circulo>("+param+")</circulo>");// TODO add your handling code here:
    }//GEN-LAST:event_hcirculoActionPerformed

    private void documentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentationActionPerformed

        this.documentacion();// TODO add your handling code here:
    }//GEN-LAST:event_documentationActionPerformed

    private void autoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoursActionPerformed

        this.autores();// TODO add your handling code here:
    }//GEN-LAST:event_autoursActionPerformed

    private void menuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuKeyReleased

//        areainterna.setSize(this.contenedor.getWidth(), this.contenedor.getHeight());// TODO add your handling code here:
    }//GEN-LAST:event_menuKeyReleased

    private void areacodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areacodigoKeyReleased

        if(this.bopciones.isSelected()==true){
            this.panelopciones.setVisible(true);
        }
        else  if(this.bopciones.isSelected()==false){
            this.panelopciones.setVisible(false);
        }
        if(this.bherramientas.isSelected()==true){
            this.herramientas.setVisible(true);
        }
        else  if(this.bherramientas.isSelected()==false){
            this.herramientas.setVisible(false);
        }

//        areainterna.setSize(this.contenedor.getWidth(), this.contenedor.getHeight());// TODO add your handling code here:
    }//GEN-LAST:event_areacodigoKeyReleased

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed

        Muestra ejecuta;
        ejecuta=new Muestra(areacodigo);
        ejecuta.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_ejecutarActionPerformed

    private void circActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circActionPerformed

        String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(panelopciones,"ingrese los parametros"
            + " Separados por coma\n EJEMPLO: 10,10,10\ntomando en cuenta(x,y,radio)");
        if(datos.isEmpty())
        areacodigo.setText("<XML>");
        else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<circulo>("+param+")</circulo>");// TODO add your handling code here:
    }//GEN-LAST:event_circActionPerformed

    private void rectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectActionPerformed

        String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(this.areacodigo,"ingrese los parametros"
            + " Separados por coma\n EJEMPLO: 10,10,10,10\ntomando en cuenta (x,y,base,altura)");
        if(datos.isEmpty())
        areacodigo.setText("<XML>");
        else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<rectangulo>("+param+")</rectangulo>");// TODO add your handling code here:
    }//GEN-LAST:event_rectActionPerformed

    private void linActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linActionPerformed

        String datos=areacodigo.getText();
        String param=JOptionPane.showInputDialog(this.areacodigo,"ingrese los parametros"
            + " Separados por coma\n EJEMPLO: 10,10,10,10\ntomando en cuenta (x,y,largo,angulo)");
        if(datos.isEmpty())
        areacodigo.setText("<XML>");
        else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n<linea>("+param+")</linea>");// TODO add your handling code here:
    }//GEN-LAST:event_linActionPerformed

    private void colrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colrActionPerformed

        JFrame frame = new JFrame("Seleccione Color");
        String ouputcolor = (String) JOptionPane.showInputDialog(frame,
            "Elije el color Que deseas...."," ",JOptionPane.QUESTION_MESSAGE,null,
            selectcolor,
            selectcolor);
        System.out.printf("color %s.\n", ouputcolor);
        this.color=ouputcolor;
        String abrir="<color>",cerrar="</color>";
        this.coloress();
        String datos=areacodigo.getText();
        if(datos.isEmpty())
        areacodigo.setText("<XML>");
        else{}
        this.areacodigo.setText(this.areacodigo.getText()+"\n"+abrir+color+cerrar);// TODO add your handling code here:
    }//GEN-LAST:event_colrActionPerformed

    private void LimpiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarAreaActionPerformed

        this.areacodigo.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_LimpiarAreaActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed

        this.BUSCARarchivo();// TODO add your handling code here:
    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        this.guardarproyecto();// TODO add your handling code here:
    }//GEN-LAST:event_GuardarActionPerformed

    private void areacodigoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areacodigoMousePressed

        areacodigo.addMouseListener(new MouseAdapter(){
        public void mouseReleased(MouseEvent Me){
            if(Me.getButton()==MouseEvent.BUTTON3){
        Pmenu.show(Me.getComponent(), Me.getX(), Me.getY());
            }
        }
        });// TODO add your handling code here:
    }//GEN-LAST:event_areacodigoMousePressed

    private void areacodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areacodigoKeyPressed
        String codigo=areacodigo.getText();
        for(int i=0;i<codigo.length();i++){
           
        }
      // TODO add your handling code here:
    }//GEN-LAST:event_areacodigoKeyPressed

    private void colores() {
        
        if(this.txtcolor.getSelectedItem()=="Azul")
            color="(33,25,200)";
        if(this.txtcolor.getSelectedItem()=="Aqua")
            color="(33,255,200)";
        if(this.txtcolor.getSelectedItem()=="Amarillo")
            color="(251,230,19)";
        if(this.txtcolor.getSelectedItem()=="Anaranjado")
            color="(251,114,19)";
        if(this.txtcolor.getSelectedItem()=="Celeste")    
            color="(19,251,230)";
        if(this.txtcolor.getSelectedItem()=="Cafes")    
            color="(124,70,75)";
        if(this.txtcolor.getSelectedItem()=="Fusia")    
            color="(174,3,191)";
        if(this.txtcolor.getSelectedItem()=="Gris")
            color="(179,179,179)";
        if(this.txtcolor.getSelectedItem()=="Morado")
            color="(130,20,150)";
        if(this.txtcolor.getSelectedItem()=="Verde")
            color="(40,150,20)";
        if(this.txtcolor.getSelectedItem()=="Verde Claro")
            color="(135,231,125)";
        if(this.txtcolor.getSelectedItem()=="Rojo")
            color="(191,3,20)";
        if(this.txtcolor.getSelectedItem()=="Rosado")  {
            color="(219,122,230)";}
        
    }
     private void coloress() {
        
        if(color=="Azul")
            color="(33,25,200)";
        if(color=="Aqua")
            color="(33,255,200)";
        if(color=="Amarillo")
            color="(251,230,19)";
        if(color=="Anaranjado")
            color="(251,114,19)";
        if(color=="Celeste")    
            color="(19,251,230)";
        if(color=="Cafes")    
            color="(124,70,75)";
        if(color=="Fusia")    
            color="(174,3,191)";
        if(color=="Gris")
            color="(179,179,179)";
        if(color=="Morado")
            color="(130,20,150)";
        if(color=="Verde")
            color="(40,150,20)";
        if(color=="Verde Claro")
            color="(135,231,125)";
        if(color=="Rojo")
            color="(191,3,20)";
        if(color=="Rosado")  {
            color="(219,122,230)";}
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem LimpiarArea;
    private javax.swing.JPopupMenu Pmenu;
    private javax.swing.JButton abrirbtt;
    private javax.swing.JMenuItem abrirp;
    private javax.swing.JEditorPane areacodigo;
    private javax.swing.JButton autours;
    private javax.swing.JCheckBoxMenuItem bherramientas;
    private javax.swing.JMenu blanco;
    private javax.swing.JCheckBoxMenuItem bopciones;
    private javax.swing.JMenuItem circ;
    private org.edisoncor.gui.button.ButtonTask circulobtt;
    private org.edisoncor.gui.button.ButtonTask colorbtt;
    private javax.swing.JMenuItem colr;
    private javax.swing.JButton documentation;
    private javax.swing.JMenuItem ejecutar;
    private javax.swing.JButton ejecutarbtt;
    private javax.swing.JMenu exit;
    private javax.swing.JMenu file;
    private javax.swing.JButton guardarbtt;
    private javax.swing.JMenuItem guardarp;
    private javax.swing.JMenuItem hcirculo;
    private javax.swing.JMenuItem hcolor;
    private javax.swing.JMenu herramient;
    private javax.swing.JPanel herramientas;
    private javax.swing.JMenuItem hlinea;
    private javax.swing.JMenuItem hrectangulo;
    private javax.swing.JMenu insesrtar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JMenuItem lin;
    private org.edisoncor.gui.button.ButtonTask lineabtt;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton nuevobtt;
    private javax.swing.JMenuItem nuevop;
    private javax.swing.JMenuItem oautores;
    private javax.swing.JMenuItem odocumentacion;
    private javax.swing.JMenuItem oejecutar;
    private javax.swing.JMenu option;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JMenuItem rect;
    private org.edisoncor.gui.button.ButtonTask rectangulobtt;
    private javax.swing.JMenuItem salirp;
    private org.edisoncor.gui.comboBox.ComboBoxRound txtcolor;
    private javax.swing.JMenu view;
    // End of variables declaration//GEN-END:variables
}
