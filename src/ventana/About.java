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
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**About dialogo sobre la aplicacion*/
public class About extends JDialog {

    /**
     * Creates new form About
     */
    public About(JFrame parent) {
        super(parent,true);
        initComponents();
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        copyrightTextArea = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Quadtree");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        copyrightTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        copyrightTextArea.setColumns(25);
        copyrightTextArea.setEditable(false);
        copyrightTextArea.setLineWrap(true);
        copyrightTextArea.setRows(8);
        copyrightTextArea.setText("  \n\t\n    Copyright (c) 2007  Gustavo Bazán, Armando Bracho.");
        copyrightTextArea.setWrapStyleWord(true);
        copyrightTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyrightTextArea.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 24, 0);
        mainPanel.add(copyrightTextArea, gridBagConstraints);

        closeButton.setMnemonic('C');
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        mainPanel.add(closeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**Salir*/
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea copyrightTextArea;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

}
