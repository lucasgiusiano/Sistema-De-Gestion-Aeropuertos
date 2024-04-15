package sistemaAutogestion;

import dominio.Aerolinea;
import dominio.Avion;
import dominio.Vuelo;
import listas.ListaSimple;
import sistemaAutogestion.Retorno.Resultado;

public class Sistema implements IObligatorio {

    public ListaSimple<Aerolinea> aerolineas;

    @Override
    public Retorno crearSistemaDeGestion() {

        return Retorno.noImplementada();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Resultado ret = null;

        Aerolinea nueva = new Aerolinea(nombre, pais, cantMaxAviones);

        if (aerolineas.estaElemento(nueva)) {
            ret = ret.ERROR_1;
        } else if (cantMaxAviones <= 0) {
            ret = ret.ERROR_2;
        } else {
            ret = ret.OK;
            aerolineas.agregarFinal(nueva);
        }

        return new Retorno(ret);
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Resultado ret = null;

        Aerolinea aBorrar = aerolineas.obtenerElemento(new Aerolinea(nombre)).getDato();
        
        if (aBorrar == null) {
            ret = ret.ERROR_1;
        }else if(aBorrar.getAviones().cantElementos() > 0){
            ret = ret.ERROR_2;
        }else{
            ret = ret.OK;
            aerolineas.borrarElemento(aBorrar);
        }
        
        return new Retorno(ret);
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {

        return Retorno.noImplementada();
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarAerolineas() {
        
        return Retorno.ok();
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        return Retorno.noImplementada();
    }

    // Aplicar recursivamente
    @Override
    public Retorno listarClientes() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarVuelos() {
        return Retorno.noImplementada();
    }

    // Aplicar recursivamente
    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        return Retorno.noImplementada();
    }

}
