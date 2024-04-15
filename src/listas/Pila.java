/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import Interfaces.IPila;

/**
 *
 * @author Lucas
 */
public class Pila<T> implements IPila<T> {

    private Nodo<T> inicio;

    @Override
    public void apilar(T elemento) {
        if (esVacia()) {
            inicio.setDato(elemento);
        } else {
            Nodo aux = getInicio();

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(new Nodo(elemento));
        }
    }

    @Override
    public T desapilar() {
        Nodo<T> aBorrar = getInicio();

        if (!esVacia()) {
            inicio = getInicio().getSiguiente();
            aBorrar.setSiguiente(null);
        }
        return (T) aBorrar;
    }

    @Override
    public T cima() {
        return (T) getInicio();
    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
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
    public void mostrar() {
        Nodo<T> aux = getInicio();

        while (aux != null) {
            System.out.print(aux.getDato() + " ");
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
    public void vaciar() {
        inicio = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

}
