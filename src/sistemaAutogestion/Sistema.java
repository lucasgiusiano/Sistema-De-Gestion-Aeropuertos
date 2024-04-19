package sistemaAutogestion;

import dominio.Aerolinea;
import dominio.Avion;
import dominio.Cliente;
import dominio.Vuelo;
import listas.ListaSimple;
import sistemaAutogestion.Retorno.Resultado;

public class Sistema implements IObligatorio {

    public ListaSimple<Aerolinea> aerolineas; //"2.1. Listar Aerolíneas" pide listar todas las aerolineas del SISTEMA (Se listan las aerolíneas ordenadas alfabéticamente.)
    public ListaSimple<Cliente> clientes; //"2.3. Listar Clientes" pide listar todos los clientes del SISTEMA (el último registrado debe mostrarse primero)
    public ListaSimple<Vuelo> vuelos; //"2.4. Listar Vuelos" pide listar todos los vuelos del SISTEMA
                                      //"2.6. Reporte de pasajes devueltos" pide buscar todos los pasajes devueltos de una aerolinea la lista general
                                      //facilitaria ingresar a la lista de vuelos con el nombre de la aerolinea y extraer de estos toda su lista de pasajes devueltos
    
    public Sistema() {
        aerolineas = new ListaSimple<Aerolinea>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        aerolineas = new ListaSimple<Aerolinea>();
        return Retorno.ok();
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
        } else if (aBorrar.getAviones().cantElementos() > 0) {
            ret = ret.ERROR_2;
        } else {
            ret = ret.OK;
            aerolineas.borrarElemento(aBorrar);
        }

        return new Retorno(ret);
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Resultado ret = null;

        Avion nueva = new Avion(nomAerolinea, codigo, capacidadMax);

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();

        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            ret = ret.ERROR_2;
        } else if (aerolinea == null) {
            ret = ret.ERROR_3;
        } else if (aerolinea.getAviones().estaElemento(nueva)) {
            ret = ret.ERROR_1;
        } else if (aerolinea.getCantMaxAviones() == aerolinea.getAviones().cantElementos()) {
            ret = ret.ERROR_4;
        } else {
            ret = ret.OK;
            aerolinea.getAviones().agregarFinal(nueva);
        }
        return new Retorno(ret);
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Resultado ret = null;

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();
        Avion aBorar = aerolinea.getAviones().obtenerElemento(new Avion(codAvion, aerolinea.getNombre())).getDato();

        if (aerolinea == null) {
            ret = ret.ERROR_1;
        } else if (aBorar == null) {
            ret = ret.ERROR_2;
        } else if (aBorar.getVuelos().cantElementos() > 0) {
            ret = ret.ERROR_3;
        } else {
            ret = ret.OK;
            aerolinea.getAviones().borrarElemento(aBorar);
        }
        return new Retorno(ret);
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

        Resultado ret = null;

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nombre)).getDato();

        if (aerolinea == null) {
            ret = ret.ERROR_1;
        } else {
            ret = ret.OK;
            aerolinea.getAviones().mostrar();
        }
        return new Retorno(ret);
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
