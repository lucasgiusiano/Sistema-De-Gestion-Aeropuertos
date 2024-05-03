/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import listas.ListaSimple;

/**
 *
 * @author Lucas
 */
public class Vuelo implements Comparable<Avion>{

    private Vuelo vuelo;
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

    public Vuelo(Vuelo vuelo, Aerolinea aerolinea, Avion avion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        this.vuelo = vuelo;
        this.aerolinea = aerolinea;
        this.avion = avion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
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
    public int compareTo(Avion o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
