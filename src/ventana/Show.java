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
import java.util.LinkedList;
import java.util.List;
import quadtree.*;
import java.io.*;
import javax.swing.*;

/**Ventana para mostrar informacion*/
public class Show extends JDialog {

    /**
     * Creates new form Show
     */
    public Show(JFrame parent) {
        //super(parent,true);
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
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(closeButton, gridBagConstraints);

        textArea.setColumns(25);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setRows(8);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea.setFocusable(false);
        scrollPane.setViewportView(textArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(scrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    /**Salir.*/
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    
    /**Muestra el Archivo de entrada o salida.*/
    public void showInOut(File file){
        
        setTitle(file.toString());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            try {
                textArea.setText("");
                while ((str = br.readLine()) != null)
                {
                    str += "\n";
                    textArea.append(str);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**Procesa los datos, mostrandolos tanto por pantalla como guardandolos
     *en el archivo de salida
     */
    public void process(File file){
        
        setTitle(file.toString());
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = null;
            try {
                fw = new FileWriter("quadtree.out");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            int j, i, N, pixels=0;
            String str = null;
            Quadtree Arbol, Arbol2, SumaDeArboles;

            List preOrden = new LinkedList();
            Arbol = new Quadtree();
            Arbol2 = new Quadtree();
            SumaDeArboles = new Quadtree();

            try {
                str = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            N = Integer.valueOf(str).intValue();
            for(j=0; j < 2*N; j++){
                try {
                    str = br.readLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                preOrden.clear();
                for(i=0; i<str.length(); i++) {
                    ColorQuad c = new ColorQuad();
                    switch (str.charAt(i)) {
                            case 'p': c.setColor("GRIS"); break;
                            case 'e': c.setColor("BLANCO"); break;
                            case 'f': c.setColor("NEGRO"); break;
                    }
                    preOrden.add(c);
                }
                if((j % 2) == 0) {
                    Arbol.crear(preOrden);
                }
                else {
                    Arbol2.crear(preOrden);
                    SumaDeArboles = Quadtree.union(Arbol, Arbol2);
                    pixels = SumaDeArboles.pixelsEnNegro(SumaDeArboles,3,1);
                    textArea.append("Hay " + pixels + " pixels negros\n");
                    try {
                        fw.write("Hay " + pixels + " pixels negros\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Arbol.nulo();
                    Arbol2.nulo();
                }
            }
            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.gc();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }        
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

}
