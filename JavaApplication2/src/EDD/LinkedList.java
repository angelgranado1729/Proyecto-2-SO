/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author angel
 */
public class LinkedList<T> {

    // Atributos de la clase
    private Node<T> pFirst;
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
        Node<T> pAux = getpFirst();
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
    public Node<T> next(Node<T> pNode) {
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
    public Node<T> first() {
        return getpFirst();
    }

    /**
     * Elimina el primer nodo de la lista.
     */
    public void deleteFirst() {
        if (!isEmpty()) {
            Node<T> pAux = getpFirst();
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
    public Node<T> deleteAndReturn(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getiSize()) {
                Node<T> pAux = getpFirst();
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
    public void addEnd(T tInfo) {
        Node<T> pNode = new Node<>(tInfo);
        if (isEmpty()) {
            setpFirst(pNode);
        } else {
            Node<T> pAux = first();
            while (next(pAux) != null) {
                pAux = next(pAux);
            }
            pAux.setNextNode(pNode);
        }
        setiSize(getiSize() + 1);
    }

    /**
     * @return the pFirst
     */
    public Node<T> getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node<T> pFirst) {
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