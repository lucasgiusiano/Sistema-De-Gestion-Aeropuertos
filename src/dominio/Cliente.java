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
public class Cliente {

    private String pasaporte;
    private String nombre;
    private int edad;
    // private ListaSimple<Vuelo> vuelosCliente; - "2.5. Listar vuelos de cliente" pide listar los vuelos en los que el cliente compro o compro y devolvio un pasaje

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Son la misma instancia
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // No son del mismo tipo
        }
        Cliente otroCliente = (Cliente) obj;
        // Solo se compara el pasaporte para determinar la igualdad
        return Objects.equals(pasaporte, otroCliente.pasaporte);
    }
}
