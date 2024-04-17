/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import listas.Cola;

/**
 *
 * @author Lucas
 */
public class Avion {

    private String nomAerolinea;
    private String codAvion;
    private int capacidadMax;
    private Cola<Vuelo> vuelos;

    public Avion(String nomAerolinea, String codAvion, int capacidadMax) {
        this.nomAerolinea = nomAerolinea;
        this.codAvion = codAvion;
        this.capacidadMax = capacidadMax;
        vuelos = new Cola<Vuelo>();
    }

    public Avion(String codAvion, String nomAerolinea) {
        this.codAvion = codAvion;
        this.nomAerolinea = nomAerolinea;

    }

    public String getNomAerolinea() {
        return nomAerolinea;
    }

    public void setNomAerolinea(String nomAerolinea) {
        this.nomAerolinea = nomAerolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public Cola<Vuelo> getVuelos() {
        return vuelos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Son la misma instancia
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // No son del mismo tipo
        }
        Avion otroAvion = (Avion) obj;
        // Solo se compara el nombre para determinar la igualdad
        return Objects.equals(codAvion, otroAvion.codAvion) && Objects.equals(nomAerolinea, otroAvion.nomAerolinea) ;
    }
    
     @Override
    public String toString() {
        return codAvion + " - " + capacidadMax;
    }
}
