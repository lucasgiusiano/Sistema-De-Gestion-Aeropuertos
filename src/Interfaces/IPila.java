/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import listas.Nodo;

/**
 *
 * @author Lucas
 */
public interface IPila<T> {

    void apilar(T elemento);

    T desapilar();

    T cima();

    boolean esVacia();

    public int cantElementos();

    public void mostrar();

    public boolean estaElemento(T n);

    public Nodo<T> obtenerElemento(T n);

    void vaciar();
}
