/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
//import listas.Cola;

/**
 *
 * @author Lucas
 */
public class Avion implements Comparable<Avion> {

    private Aerolinea aerolinea;
    private String codAvion;
    private int capacidadMax;
    //private Cola<Vuelo> vuelos; //Factible cambiarlo a la clase sistema debido a que no pueden haber dos codigos de vuelos iguales en el sistema (1.7 Error 1)
                                //1.7 Error 3 "En caso de que el código de avión no exista dentro de la aerolínea" reafirma la necesidad de tener aviones dentro de la aerolinea

    public Avion(Aerolinea aerolinea, String codAvion, int capacidadMax) {
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.capacidadMax = capacidadMax;
        //vuelos = new Cola<Vuelo>();
    }

    public Avion(String codAvion, Aerolinea aerolinea) {
        this.codAvion = codAvion;
        this.aerolinea = aerolinea;
    }

    public Avion(String codAvion) {
        this.codAvion = codAvion;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
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
        return Objects.equals(codAvion, otroAvion.codAvion) && Objects.equals(aerolinea.getNombre(), otroAvion.aerolinea.getNombre()) ;
    }
    
     @Override
    public String toString() {
        return codAvion + "-" + capacidadMax + "|\n" ;
    }

    @Override
    public int compareTo(Avion o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
