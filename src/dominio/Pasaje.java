/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Lucas
 */
public class Pasaje implements Comparable<Avion>{
    private String pasaporteCliente;
    private String codigoVuelo;
    private int categoriaPasaje;

    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje) {
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoriaPasaje = categoriaPasaje;
    }

    public String getPasaporteCliente() {
        return pasaporteCliente;
    }

    public void setPasaporteCliente(String pasaporteCliente) {
        this.pasaporteCliente = pasaporteCliente;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getCategoriaPasaje() {
        return categoriaPasaje;
    }

    public void setCategoriaPasaje(int categoriaPasaje) {
        this.categoriaPasaje = categoriaPasaje;
    }
    
    public void Validar() throws Exception{
        if (categoriaPasaje != 1 && categoriaPasaje != 2) {
            throw new Exception("El valor de la categoria solo puede ser 1- Económica, 2- Primera Clase");
        }
    }

    @Override
    public int compareTo(Avion o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
