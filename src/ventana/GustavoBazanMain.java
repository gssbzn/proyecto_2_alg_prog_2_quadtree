/**
 * <p>Title: Proyecto 2 de Algoritmos y Programacion 2.
 *           Quadtree</p>
 *
 * <p>Description: Un quadtree es un formato utilizado para la representación
 *                 de imágenes.  La idea fundamental tras el quadtree es que
 *                 cualquier imagen puede ser dividida en cuatro cuadrantes.
 *                 Cada cuadrante puede a su vez ser dividido en cuatro
 *                 sub-cuadrantes, y así sucesivamente.  De esta manera, un
 *                 quadtree es un árbol 4-ario que permite representar de
 *                 manera compacta una imagen, que en otro caso podría ocupar
 *                 grandes cantidades de memoria.  En el quadtree la imagen
 *                 es representada por un nodo padre, mientras que los cuatro
 *                 cuadrantes son representados por cuatro nodos hijos, en un
 *                 orden predeterminado.
 *
 *                 En general, un cuadrante sólo requiere ser subdividido si
 *                 contiene pixels de diferentes colores.  En consecuencia,
 *                 un quadtree no es necesariamente un árbol balanceado.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Gustavo Bazán & Armando Bracho
 *
 * @version 2.1
 */

package ventana;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import utils.*;

/**Ventana principal*/

public class GustavoBazanMain extends JFrame {

    public static void main(String[] args) {
        new GustavoBazanMain().setVisible(true);
    }
    /**
     * Creates new form Main
     */
    public GustavoBazanMain() {
        initComponents();
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.width) / 2));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        showInOutMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        process = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setTitle("Asignacion");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventana/Logo facyt.GIF"))); // NOI18N
        mainPanel.add(logo, new java.awt.GridBagConstraints());

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        mainMenu.setForeground(new java.awt.Color(0, 0, 255));

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        showInOutMenuItem.setMnemonic('S');
        showInOutMenuItem.setText("Show Files");
        showInOutMenuItem.setToolTipText("Muestra el contenido del archivo seleccionado");
        showInOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInOutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(showInOutMenuItem);
        fileMenu.add(jSeparator1);

        process.setMnemonic('P');
        process.setText("Process");
        process.setToolTipText("Procesar el archivo de entrada");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });
        fileMenu.add(process);
        fileMenu.add(jSeparator2);

        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.setToolTipText("About Quadtree");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(aboutMenuItem);

        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenu.add(fileMenu);

        setJMenuBar(mainMenu);
    }// </editor-fold>//GEN-END:initComponents

    /**Procesar el archivo de entrada.*/
    private void processActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_processActionPerformed
        Show archivo = new Show(this);
        JFileChooser fc;
        fc = new JFileChooser();
        fc.addChoosableFileFilter(new InFilter());
        fc.setAcceptAllFileFilterUsed(false);
        
        int returnVal = fc.showOpenDialog(GustavoBazanMain.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            archivo.process(file);
            archivo.setVisible(true);
        }            
    }//GEN-LAST:event_processActionPerformed

    /**Mostrar el archivo de entrada o el archivo de salida".*/
    private void showInOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_showInMenuItemActionPerformed
        Show archivo = new Show(this);
        JFileChooser fc;
        fc = new JFileChooser();
        fc.addChoosableFileFilter(new InOutFilter());
        fc.setAcceptAllFileFilterUsed(false);
        
        int returnVal = fc.showOpenDialog(GustavoBazanMain.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            archivo.showInOut(file);
            archivo.setVisible(true);
        }
    }//GEN-LAST:event_showInMenuItemActionPerformed

    /**Mostrar la ventana con la informacion del producto.*/
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_aboutMenuItemActionPerformed
        new About(this).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**Salir*/
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed
    
    /**Salir*/
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem process;
    private javax.swing.JMenuItem showInOutMenuItem;
    // End of variables declaration//GEN-END:variables

}
