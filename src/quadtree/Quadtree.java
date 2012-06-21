
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

package quadtree;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

//~--- classes ----------------------------------------------------------------

public class Quadtree {
    Nodo arbol;

    //~--- methods ------------------------------------------------------------
    
    /**
     * Retorna un <tt>Quadtree</tt> nulo.
     */
    public void nulo() {
        arbol = null;
        System.gc();
    }
    
    /**
     * Indica si el <tt>Quadtree</tt> es nulo .
     * @return   <tt>true</tt> si es nulo.
     */
    public boolean esNulo() {
        return arbol == null;
    }
    
    /**
     * Crea un <tt>Quadtree</tt> a partir de la lista que contiene el color
     * de sus nodos en preorden.
     * @param    preOrden   la lista con el recorrido del arbol en preorden.
     */
    public void crear(List preOrden) {
        ColorQuad c = new ColorQuad();

        arbol = new Nodo();
        c.setColor(preOrden.get(0).toString());
        arbol.setColor(c);
        preOrden.remove(0);
	
	if (preOrden.size()==0) return;
	
        int i = 0;
	
        while (i < 4) {
            c = new ColorQuad();
            c.setColor(preOrden.get(0).toString());

            if (c.toString() == "GRIS") {
                Quadtree temp = new Quadtree();

                temp.crear(preOrden);
                arbol.setSubArbol(temp.getNodo());
            } else {

                Nodo aux = new Nodo();

                aux.setColor(c);
                arbol.setSubArbol(aux);
                preOrden.remove(0);
            }

            i++;
        }
    }

    /**
     * Retorna el color del nodo raíz del <tt>Quadtree</tt>.
     * @return   el color de la raiz.
     */
    public ColorQuad color() {
        return arbol.getColor();
    }

    /**
     * Retorna el quadtree resultante de la suma de Qt1 y Qt2.
     * @param    Qt1   un <tt>Quadtree</tt>.
     * @param    Qt2   un <tt>Quadtree</tt>.
     * @return   el <tt>Quadtree</tt> resultante de unir Qt1 y Qt2.
     */
    public static Quadtree union(Quadtree Qt1, Quadtree Qt2) {
        Quadtree c        = new Quadtree();
        List     preOrden = new LinkedList();

        getPreOrden(preOrden, Qt1.getNodo(), Qt2.getNodo());
        c.crear(preOrden);

        return c;
    }

    /**
     * Retorna la cantidad de pixels negros de Qt cuya altura máxima es maxAlt.
     * @param    Qt  un <tt>Quadtree</tt>.
     * @param    maxAlt  el nivel maximo del <tt>Quadtree</tt>.
     * @param    nivel   el nivel donde se esta del <tt>Quadtree</tt>.
     * @return   el numero de pixels negros.
     */
    public int pixelsEnNegro(Quadtree Qt, int maxAlt, int nivel) {
        int i     = 0,
            total = 0;
	if(Qt.color().toString() == "NEGRO"){
		total = 64;
	
	} else {

        if (maxAlt != 1) {
            while (i < 4) {
                Quadtree temp = new Quadtree();

                temp.arbol = Qt.arbol.getSubArbol(i);

                if ((temp.color().toString() == "GRIS") && (maxAlt > 1)) {
                    total = total
                            + Qt.pixelsEnNegro(temp, maxAlt - 1, nivel + 1);
                } else {
                    if (temp.color().toString() == "NEGRO") {
                        switch (nivel) {
                        case 1 :
                            total = total + 16;
                            break;

                        case 2 :
                            total = total + 4;
                            break;

                        case 3 :
                            total = total + 1;
                            break;
                        }
                    }
                }

                i++;
            }
        } else {
            while (i < 4) {
                if (Qt.arbol.getSubArbol(i).getColor().toString() == "NEGRO") {
                    total++;
                }
                i++;
            }

            switch (nivel) {
            case 1 :
                total = total * 16;
                break;

            case 2 :
                total = total * 4;
                break;
            }
            return total;
	}

	}
        return total;
    }
    
    /**
     * Muestra el pre Orden de un Quadtree.
     */
    public void showPreOrden() {
        List ord = new LinkedList();

        getPreOrden(ord, arbol);
        System.out.println(ord);
    }
    
    //~--- get methods --------------------------------------------------------
    
    /**
     * Devuelve el nodo raíz del <tt>Quadtree</tt>.
     *@return	el nodo raíz del <tt>Quadtree</tt>.
     */
    public Nodo getNodo() {
        return arbol;
    }

    /**
     * Devuelve el preorden de un <tt>Quadtree</tt>.
     */
    public static void getPreOrden(List preOrden, Nodo padre) {
        preOrden.add(padre.getColor().toString());

        for (int i = 0; i < 4; i++) {
            if (padre.getSubArbol(i) != null) {
                getPreOrden(preOrden, padre.getSubArbol(i));
            }
        }
    }

    /**
     * Devuelve el preorden generado apartir de la unión de dos
     * <tt>Quadtree</tt>'s.
     */
    private static void getPreOrden(List preOrden, Nodo padreA, Nodo padreB) {
        String A, B;

        A = padreA.getColor().toString();
        B = padreB.getColor().toString();

        if ((A == "NEGRO") || (B == "NEGRO")) {
            preOrden.add("NEGRO");
        } 
        else {
        	if (A == "BLANCO") {
                getPreOrden(preOrden, padreB);
        	}
        	else if (B == "BLANCO") {
                getPreOrden(preOrden, padreA);
            }
        	else if ((A == "GRIS") && (B == "GRIS")) {
        		int i, tam;
        		boolean sux=true;
        		preOrden.add(A);
                tam=preOrden.size();
                for (i = 0; i < 4; i++) {
                    getPreOrden(preOrden, padreA.getSubArbol(i),
                                padreB.getSubArbol(i));
                }
                for(i = tam; i < tam + 4 && sux; i++){
                	if(preOrden.get(i) == "BLANCO" || preOrden.get(i) == "GRIS") sux=false;
                }
                if(sux){
                	preOrden.set(tam-1, "NEGRO");
                	for(i = tam; i < tam + 4; i++){
                		preOrden.remove(tam);
                	}
                }               		
            }
        }
    }
    
}
