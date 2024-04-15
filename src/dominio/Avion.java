/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

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
    
    
    
    
}
