/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dominio.Nodo;

/**
 *
 * @author Lucas
 */
public interface ILista<T> {

    public boolean esVacia();

    public void agregarInicio(T n);

    public void agregarFinal(T n);

    public void borrarInicio();

    public void borrarFin();

    public void vaciar();

    public void mostrar();

    public boolean estaElemento(T n);

    public int cantElementos();

    public Nodo<T> obtenerElemento(T n);

    public void mostrarREC(Nodo<T> l);

    public void borrarElemento(T n);

    public void agregarOrdenado(int n);
}
