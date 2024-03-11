/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import MainClasses.CharacterTv;

/**
 *
 * @author angel
 */
public class LinkedList {

    // Atributos de la clase
    private Node pFirst;
    private int iSize;

    /**
     * Constructor de la clase
     */
    public LinkedList() {
        this.pFirst = null;
        this.iSize = 0;
    }

    /**
     * Destruye la lista completamente.
     */
    public void destroy() {
        Node pAux = getpFirst();
        while (pAux != null) {
            pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
        }
        setiSize(0);
        System.gc();
    }

    /**
     * Dado un nodo de la lista, retorna el siguiente nodo enlazado.
     *
     * @param pNode, un nodo que pertenece a la lista.
     * @return null si el nodo dado no pertenece a la lista o si es el ultimo,
     * en caso contrario retorna el siguiente nodo enlazado.
     */
    public Node next(Node pNode) {
        if (pNode != null) {
            return pNode.getNextNode();
        } else {
            return null;
        }
    }

    /**
     * Verifica si la lista es vacia.
     *
     * @return retorna true si la lista esta vacia, en caso contrario retorna
     * false.
     */
    public boolean isEmpty() {
        return getpFirst() == null;
    }

    /**
     * Retorna el numero de nodos que conforman la lista.
     *
     * @return el tamaño de la lista.
     */
    public int size() {
        return getiSize();
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return el primer nodo.
     */
    public Node first() {
        return getpFirst();
    }

    /**
     * Elimina el primer nodo de la lista.
     */
    public void deleteFirst() {
        if (!isEmpty()) {
            Node pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
            setiSize(getiSize() - 1);
        }
    }

    /**
     * Elimina el nodo de la posicion dada y lo retorna.
     *
     * @param index, la posicion dada.
     * @return el nodo que ha sido eliminado, si no pertenece a la lista
     * entonces retorna null.
     */
    public Node deleteAndReturn(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getiSize()) {
                Node pAux = getpFirst();
                if (index == 0) {
                    setpFirst(next(pAux));
                    setiSize(getiSize() - 1);
                    return pAux;
                } else {
                    for (int i = 0; i < index - 1; i++) {
                        pAux = next(pAux);
                    }
                    pAux.setNextNode(next(next(pAux)));
                    setiSize(getiSize() - 1);
                    return pAux;
                }
            }
            return null;
        }
        return null;
    }

    /**
     * Guarda la informacion dada en un nuevo nodo que sera insertado en la
     * ultima posicion de la lista.
     *
     * @param tInfo, la informacion a guardar.
     */
    public void addEnd(CharacterTv tInfo) {
        Node pNode = new Node(tInfo);
        if (isEmpty()) {
            setpFirst(pNode);
        } else {
            Node pAux = first();
            while (next(pAux) != null) {
                pAux = next(pAux);
            }
            pAux.setNextNode(pNode);
        }
        setiSize(getiSize() + 1);
    }

    /**
     * Inserta un nuevo elemento en la lista de manera ordenada. La comparación
     * se hace por el nombre del personaje, de forma alfabética.
     *
     * @param newCharacter El nuevo personaje a insertar en la lista.
     */
    public void insertOrdered(CharacterTv newCharacter) {
        Node newNode = new Node(newCharacter);
        Node current = pFirst;
        Node previous = null;
        
        
        current.getTInfo().getChapterId();

        // Buscar la posición correcta para la inserción
        while (current != null && current.getTInfo().getNameCharacter().compareToIgnoreCase(newCharacter.getNameCharacter()) < 0) {
            previous = current;
            current = current.getNextNode();
        }

        // Si debe ir al principio de la lista
        if (previous == null) {
            newNode.setNextNode(pFirst);
            pFirst = newNode;
        } else {
            // Inserción en medio o al final de la lista
            newNode.setNextNode(current);
            previous.setNextNode(newNode);
        }
        iSize++;
    }
    
    public void add(CharacterTv charactertv){
        
    }

    /**
     * @return the pFirst
     */
    public Node getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the iSize
     */
    public int getiSize() {
        return iSize;
    }

    /**
     * @param iSize the iSize to set
     */
    public void setiSize(int iSize) {
        this.iSize = iSize;
    }

}
