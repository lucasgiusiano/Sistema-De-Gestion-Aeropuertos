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
public interface ICola<T> {

    void encolar(T elemento);

    T desencolar();

    T frente();

    boolean esVacia();

    int cantElementos();

    public String mostrar();

    public boolean estaElemento(T n);

    public Nodo<T> obtenerElemento(T n);

    void vaciar();

}
