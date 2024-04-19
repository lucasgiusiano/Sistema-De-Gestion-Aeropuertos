/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import listas.ListaSimple;

/**
 *
 * @author Lucas
 */
public class Aerolinea implements Comparable<Aerolinea> {

    private String nombre;
    private String pais;
    private int cantMaxAviones;
    private ListaSimple<Avion> aviones; //Util para buscar aviones que tiene la aerolinea para saber si se puede agregar un avión
                                        //"2.2. Listar Aviones" pide listar los aviones de una aerolinea especifica

    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
        aviones = new ListaSimple<Avion>();

    }

    public Aerolinea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }

    public ListaSimple<Avion> getAviones() {
        return aviones;
    }

    @Override
    public int compareTo(Aerolinea a) {
        if (this.nombre.compareTo(a.getNombre()) < 0) {
            return -1;
        } else if (this.nombre.compareTo(a.getNombre()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Son la misma instancia
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // No son del mismo tipo
        }
        Aerolinea otraAerolinea = (Aerolinea) obj;
        // Solo se compara el nombre para determinar la igualdad
        return Objects.equals(nombre, otraAerolinea.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre + " - " + pais + " - " + cantMaxAviones ;
    }

}
