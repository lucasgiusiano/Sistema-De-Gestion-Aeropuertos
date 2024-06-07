/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import Interfaces.ICola;

/**
 *
 * @author Lucas
 */
public class Cola<T> implements ICola<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantElementos;
    private int cantMaxima;

    public Cola() {
        inicio = null;
        fin = null;
        cantElementos = 0;
        cantMaxima = Integer.MAX_VALUE;
    }

    public Cola(int cantMax) {
        inicio = null;
        fin = null;
        cantElementos = 0;
        cantMaxima = cantMax;
    }

    @Override
    public void encolar(T elemento) {

        if (esVacia()) {
            Nodo<T> nuevo = new Nodo<T>(elemento);
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (cantElementos < cantMaxima) {
                Nodo<T> nuevo = new Nodo<T>(elemento);
                fin.setSiguiente(nuevo);
                fin = nuevo;
            }
        }
        cantElementos++;
    }

    @Override
    public T desencolar() {
        Nodo<T> aBorrar = getInicio();

        if (!esVacia()) {
            inicio = getInicio().getSiguiente();
            aBorrar.setSiguiente(null);
            cantElementos--;
        }
        return (T) aBorrar;
    }

    @Override
    public T frente() {
        return (T) getInicio();
    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
    }

    @Override
    public String mostrar() {
        String texto = mostrarRecursivo(getInicio());
        return texto;
    }

    private String mostrarRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return "";
        }
        if (nodo.getDato() == getInicio().getDato()) {
            return mostrarRecursivo(nodo.getSiguiente()) + nodo.getDato().toString();
        }
        return mostrarRecursivo(nodo.getSiguiente()) + nodo.getDato().toString() + "\n";
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
    public Nodo<T> obtenerElemento(T n) {
        Nodo<T> aux = getInicio();
        Nodo<T> ret = new Nodo(null);

        while (aux != null && ret.getDato() == null) {
            if (aux.getDato().equals(n)) {
                ret = aux;
            }
            aux = aux.getSiguiente();
        }

        return ret;
    }

    @Override
    public void vaciar() {
        inicio = null;
        fin = null;
        cantElementos = 0;
    }

    @Override
    public int cantElementos() {
        return cantElementos;
    }

    public Nodo getFin() {
        return fin;
    }

    public Nodo getInicio() {
        return inicio;
    }

}
