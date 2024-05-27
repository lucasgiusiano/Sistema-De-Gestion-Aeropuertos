/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Pasaje implements Comparable<Pasaje> {

    private Cliente cliente;
    private Vuelo vuelo;
    private int categoriaPasaje;

    public Pasaje(Cliente cliente, Vuelo vuelo, int categoriaPasaje) {
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.categoriaPasaje = categoriaPasaje;
    }

    public Pasaje(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getCategoriaPasaje() {
        return categoriaPasaje;
    }

    public void setCategoriaPasaje(int categoriaPasaje) {
        this.categoriaPasaje = categoriaPasaje;
    }

    public void Validar() throws Exception {
        if (categoriaPasaje != 1 && categoriaPasaje != 2) {
            throw new Exception("El valor de la categoria solo puede ser 1- Económica, 2- Primera Clase");
        }
    }

    @Override
    public int compareTo(Pasaje o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pasaje other = (Pasaje) obj;
        return Objects.equals(this.cliente.getPasaporte(), other.cliente.getPasaporte());
    }
    
    
}
