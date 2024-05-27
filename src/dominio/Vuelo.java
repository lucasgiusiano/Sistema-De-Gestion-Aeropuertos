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
public class Vuelo implements Comparable<Avion> {

    private String codVuelo;
    private Aerolinea aerolinea;
    private Avion avion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int año;
    private int cantPasajesEcon;
    private int cantPasajesPClase;
    private ListaSimple<Pasaje> pasajesEconVendidos;
    private ListaSimple<Pasaje> pasajesEconPendientes;
    private ListaSimple<Pasaje> pasajesEconDevueltos;
    private ListaSimple<Pasaje> pasajesPClaseVendidos;
    private ListaSimple<Pasaje> pasajesPClasePendientes;
    private ListaSimple<Pasaje> pasajesPClaseDevueltos;

    //Para el control de pasajes vendidos, devueltos y pendientes es necesario llevar el control dentro de cada vuelo con sus listas
    public Vuelo(String codVuelo, Aerolinea aerolinea, Avion avion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        this.codVuelo = codVuelo;
        this.aerolinea = aerolinea;
        this.avion = avion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public Vuelo(int dia, int mes, int año, Avion avion) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.avion = avion;
    }
    
    public Vuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public Vuelo(Avion avion) {
        this.avion = avion;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String vuelo) {
        this.codVuelo = vuelo;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public ListaSimple<Pasaje> getPasajesEconVendidos() {
        return pasajesEconVendidos;
    }

    public void setPasajesEconVendidos(ListaSimple<Pasaje> pasajesEconVendidos) {
        this.pasajesEconVendidos = pasajesEconVendidos;
    }

    public ListaSimple<Pasaje> getPasajesEconPendientes() {
        return pasajesEconPendientes;
    }

    public void setPasajesEconPendientes(ListaSimple<Pasaje> pasajesEconPendientes) {
        this.pasajesEconPendientes = pasajesEconPendientes;
    }

    public ListaSimple<Pasaje> getPasajesEconDevueltos() {
        return pasajesEconDevueltos;
    }

    public void setPasajesEconDevueltos(ListaSimple<Pasaje> pasajesEconDevueltos) {
        this.pasajesEconDevueltos = pasajesEconDevueltos;
    }

    public ListaSimple<Pasaje> getPasajesPClaseVendidos() {
        return pasajesPClaseVendidos;
    }

    public void setPasajesPClaseVendidos(ListaSimple<Pasaje> pasajesPClaseVendidos) {
        this.pasajesPClaseVendidos = pasajesPClaseVendidos;
    }

    public ListaSimple<Pasaje> getPasajesPClasePendientes() {
        return pasajesPClasePendientes;
    }

    public void setPasajesPClasePendientes(ListaSimple<Pasaje> pasajesPClasePendientes) {
        this.pasajesPClasePendientes = pasajesPClasePendientes;
    }

    public ListaSimple<Pasaje> getPasajesPClaseDevueltos() {
        return pasajesPClaseDevueltos;
    }

    public void setPasajesPClaseDevueltos(ListaSimple<Pasaje> pasajesPClaseDevueltos) {
        this.pasajesPClaseDevueltos = pasajesPClaseDevueltos;
    }
    
    

    public void rellenar() {

    }

    public void Validar() throws Exception {
        if (cantPasajesEcon < 3 || (cantPasajesEcon % 3) != 0) {
            throw new Exception("La cantidad de pasajes de tipo economico debe ser superior a tres y multiplo de este");
        }
        if (cantPasajesPClase < 3 || (cantPasajesPClase % 3) != 0) {
            throw new Exception("La cantidad de pasajes de tipo primera clase debe ser superior a tres y multiplo de este");
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

        Vuelo otroVuelo = (Vuelo) obj;
        // Solo se compara el nombre para determinar la igualdad

        if ((this.codVuelo != null && !this.codVuelo.isEmpty()) && (otroVuelo.getCodVuelo() != null && !otroVuelo.getCodVuelo().isEmpty())) {
            return Objects.equals(codVuelo, otroVuelo.codVuelo);
        }

        if ((this.dia != 0 && this.mes != 0 && this.año != 0) && (otroVuelo.getDia() != 0 && otroVuelo.getMes() != 0 && otroVuelo.getAño() != 0) 
                && this.avion != null && otroVuelo.getAvion() != null) {
            return Objects.equals(dia, otroVuelo.dia) && Objects.equals(mes, otroVuelo.mes) && Objects.equals(año, otroVuelo.año) && avion.equals(otroVuelo.getAvion());
        }

        return this.avion.equals(otroVuelo.getAvion());

    }

    @Override
    public int compareTo(Avion o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
