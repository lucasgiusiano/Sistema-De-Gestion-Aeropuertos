package listas;

import Interfaces.ILista;

public class ListaSimple<T> implements ILista<T> {

    private Nodo<T> inicio;

    public ListaSimple() {
        inicio = null;
    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
    }

    @Override
    public void agregarInicio(T n) {

        Nodo<T> nuevo = new Nodo(n);

        nuevo.setSiguiente(getInicio());
        inicio = nuevo;
    }

    @Override
    public void agregarFinal(T n) {

        if (esVacia()) {
            agregarInicio(n);
        } else {
            Nodo aux = getInicio();

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(new Nodo(n));
        }
    }

    @Override
    public void borrarInicio() {

        if (!esVacia()) {

            Nodo<T> aBorrar = getInicio();
            inicio = getInicio().getSiguiente();
            aBorrar.setSiguiente(null);
        }
    }

    @Override
    public void borrarFin() {
        if (!esVacia()) {

            if (getInicio().getSiguiente() == null) { //tiene un solo elemento
                borrarInicio();
            } else {
                Nodo<T> aux = getInicio();

                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null);
            }
        }
    }

    @Override
    public void vaciar() {
        inicio = null;
    }

    @Override
    public void mostrar() {
        Nodo<T> aux = getInicio();

        while (aux != null) {
            System.out.print(aux.getDato().toString() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public boolean estaElemento(T n) {

        Nodo<T> aux = getInicio();
        boolean existe = false;

        while (aux != null && !existe) {
            if (aux.getDato().equals(n)) {
                existe = true;
            }
            aux = aux.getSiguiente();
        }
        return existe;

    }

    @Override
    public int cantElementos() {

        Nodo<T> aux = getInicio();
        int cant = 0;

        while (aux != null) {
            cant++;
            aux = aux.getSiguiente();
        }
        return cant;

    }

    @Override
    public Nodo<T> obtenerElemento(T n) {
        Nodo<T> aux = getInicio();
        Nodo<T> ret = null;

        while (aux != null && ret == null) {
            if (aux.getDato().equals(n)) {
                ret = aux;
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    @Override
    public void borrarElemento(T n) {

        if (!esVacia()) {

            if (getInicio().getDato() == n) { //es el primero             
                borrarInicio();
            } else {

                Nodo<T> aux = getInicio();

                while (aux.getSiguiente() != null && aux.getSiguiente().getDato() != n) {
                    aux = aux.getSiguiente();
                }

                if (aux.getSiguiente() != null) {

                    Nodo<T> aBorrar = aux.getSiguiente();
                    aux.setSiguiente(aBorrar.getSiguiente());
                    aBorrar.setSiguiente(null);
                }

            }
        }
    }

    @Override
    public void agregarOrd(T n) {
        /*if (esVacia() || n.getDato().compareTo(getInicio().getDato()) > 0) { //Es el primero
            agregarInicio(n);
        } else {

            Nodo<T> aux = getInicio();

            while (aux.getSiguiente() != null && aux.getSiguiente().getDato() < n) {
                aux = aux.getSiguiente();
            }

            if (aux.getSiguiente() == null) {  //Es el último
                agregarFinal(n);
            } else {

                Nodo<T> nuevo = new Nodo(n);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
         */
    }

    /**
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

}
