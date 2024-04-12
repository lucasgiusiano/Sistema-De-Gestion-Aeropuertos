/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Lucas
 */
public class Aerolinea implements Comparable<Aerolinea> {
    private String nombre ;
    private String pais;
    private int cantMaxAviones ;

    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
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

    public int compareTo(Aerolinea a) {
        if (this.nombre.compareTo(a.getNombre()) < 0) {
            return -1;
        }else if(this.nombre.compareTo(a.getNombre()) > 0){
            return 1;
        }else{
            return 0;
        }
    }    
}
