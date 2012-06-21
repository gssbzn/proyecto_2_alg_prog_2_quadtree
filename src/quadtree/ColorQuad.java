
/**
 * <p>Title: Proyecto 2 de Algoritmos y Programacion 2.
 *           Quadtree</p>
 *
 * <p>Description: Un quadtree es un formato utilizado para la representaci�n
 *                 de im�genes.  La idea fundamental tras el quadtree es que
 *                 cualquier imagen puede ser dividida en cuatro cuadrantes.
 *                 Cada cuadrante puede a su vez ser dividido en cuatro
 *                 sub-cuadrantes, y as� sucesivamente.  De esta manera, un
 *                 quadtree es un �rbol 4-ario que permite representar de
 *                 manera compacta una imagen, que en otro caso podr�a ocupar
 *                 grandes cantidades de memoria.  En el quadtree la imagen
 *                 es representada por un nodo padre, mientras que los cuatro
 *                 cuadrantes son representados por cuatro nodos hijos, en un
 *                 orden predeterminado.
 *
 *                 En general, un cuadrante s�lo requiere ser subdividido si
 *                 contiene pixels de diferentes colores.  En consecuencia,
 *                 un quadtree no es necesariamente un �rbol balanceado.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Gustavo Baz�n & Armando Bracho
 *
 * @version 2.1
 */

package quadtree;

public class ColorQuad {
    private String color;

    //~--- methods ------------------------------------------------------------

    /** Sobrecarga del operador toString */
    public String toString() {
        return color;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * Devuelve el color.
     * @return   el color.
     */
    public String getColor() {
        return color;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * Da valor al color.
     * @param   c   el color.
     */
    public void setColor(String c) {
        color = c;
    }
}

