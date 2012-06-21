
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


public class Nodo {
    private ColorQuad color;
    private Nodo  subArboles[];

    //~--- constructors -------------------------------------------------------

    /** Creates a new instance of NodoQuadtree */
    public Nodo() {
        subArboles = new Nodo[4];
    }

    //~--- get methods --------------------------------------------------------
    
    /**Devuelve el color del nodo.
     *@return	el color del nodo.
     */
    public ColorQuad getColor() {
        return color;
    }
    
    /** Devuelve el subárbol en la posicion "pos".
     *@param	pos la posicion del subárbol que se desea.
     *@return	el sub árbol en la posicion "pos".
     */
    public Nodo getSubArbol(int pos) {
        return subArboles[pos];
    }

    //~--- set methods --------------------------------------------------------
    
    /**Da valor al color del nodo.
     *@param	c   el color. 	
     */
    public void setColor(ColorQuad c) {
        color = c;
    }
    
    /**Agrega un subárbol en la ultima posicion.
     *@param	p   el subárbol.
     */
    public void setSubArbol(Nodo p) {
        int i;

        for (i = 0; subArboles[i] != null; i++) {}

        subArboles[i] = p;
    }
}
