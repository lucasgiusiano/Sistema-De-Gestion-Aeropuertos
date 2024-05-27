package sistemaAutogestion;

import dominio.Aerolinea;
import dominio.Avion;
import dominio.Cliente;
import dominio.Pasaje;
import dominio.Vuelo;
import listas.Cola;
import listas.ListaSimple;
import listas.Nodo;
import sistemaAutogestion.Retorno.Resultado;

public class Sistema implements IObligatorio {

    public ListaSimple<Aerolinea> aerolineas; //"2.1. Listar Aerolíneas" pide listar todas las aerolineas del SISTEMA (Se listan las aerolíneas ordenadas alfabéticamente.)
    public Cola<Cliente> clientes; //"2.3. Listar Clientes" pide listar todos los clientes del SISTEMA (el último registrado debe mostrarse primero)
    public ListaSimple<Vuelo> vuelos; //"2.4. Listar Vuelos" pide listar todos los vuelos del SISTEMA
    //"2.6. Reporte de pasajes devueltos" pide buscar todos los pasajes devueltos de una aerolinea la lista general
    //facilitaria ingresar a la lista de vuelos con el nombre de la aerolinea y extraer de estos toda su lista de pasajes devueltos

    public Sistema() {
        aerolineas = new ListaSimple<Aerolinea>();
        vuelos = new ListaSimple<Vuelo>();
        clientes = new Cola<Cliente>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        aerolineas = new ListaSimple<Aerolinea>();
        vuelos = new ListaSimple<Vuelo>();
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
            aerolineas.agregarOrd(nueva);
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

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();

        Avion nueva = new Avion(aerolinea, codigo, capacidadMax);

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
            aerolinea.getAviones().agregarInicio(nueva);
        }
        return new Retorno(ret);
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Resultado ret = null;

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();

        if (aerolinea == null) {
            ret = ret.ERROR_1;
        } else {
            Nodo<Avion> aBorrar = aerolinea.getAviones().obtenerElemento(new Avion(codAvion, aerolinea));
            if (aBorrar.getDato() == null) {
                ret = ret.ERROR_2;
            } else if (vuelos.estaElemento(new Vuelo(aBorrar.getDato()))) {
                ret = ret.ERROR_3;
            } else {
                ret = ret.OK;
                aerolinea.getAviones().borrarElemento(aBorrar.getDato());
            }
        }

        return new Retorno(ret);
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        Resultado ret = null;
        Cliente nuevo = new Cliente(pasaporte, nombre, edad);

        if (edad < 0) {
            ret = ret.ERROR_1;
        } else if (pasaporte.length() != 7 && pasaporte.matches("[a-zA-Z0-9]+")) { // >> pasaporte.matches("[a-zA-Z0-9]+") << Verifica que el pasaportes sea un texto alfanumérico
            ret = ret.ERROR_2;
        } else if (clientes.estaElemento(nuevo)) {
            ret = ret.ERROR_3;
        } else {
            clientes.encolar(nuevo);
            ret = ret.OK;
        }

        return new Retorno(ret);
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        Resultado ret = null;

        Aerolinea aerolineaDelVuelo = aerolineas.obtenerElemento(new Aerolinea(aerolinea)).getDato();
        Avion avionDelVuelo = aerolineaDelVuelo.getAviones().obtenerElemento(new Avion(codAvion)).getDato();

        if (vuelos.estaElemento(new Vuelo(codigoVuelo))) {
            ret = ret.ERROR_1;
        } else if (aerolineaDelVuelo == null) {
            ret = ret.ERROR_2;
        } else if (avionDelVuelo == null) {
            ret = ret.ERROR_3;
        } else if (vuelos.estaElemento(new Vuelo(dia, mes, año, avionDelVuelo))) {
            ret = ret.ERROR_4;
        } else if (cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
            ret = ret.ERROR_5;
        } else if ((cantPasajesEcon + cantPasajesPClase) > avionDelVuelo.getCapacidadMax()) {
            ret = ret.ERROR_6;
        } else {
            if ((cantPasajesEcon + cantPasajesPClase) < avionDelVuelo.getCapacidadMax()) {
                cantPasajesEcon += avionDelVuelo.getCapacidadMax() - (cantPasajesEcon + cantPasajesPClase);
            }
            Vuelo nuevo = new Vuelo(codigoVuelo, aerolineaDelVuelo, avionDelVuelo, paisDestino, dia, mes, año, cantPasajesEcon, cantPasajesPClase);
            vuelos.agregarFinal(nuevo);
            ret = ret.OK;
        }

        return new Retorno(ret);
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

        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = aerolineas.mostrar();
        return r;
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {

        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nombre)).getDato();

        if (aerolinea == null) {
            r = Retorno.error1();
        } else {
            r = Retorno.ok();
            r.valorString = aerolinea.getAviones().mostrar();
        }
        return r;
    }

    // Aplicar recursivamente
    @Override
    public Retorno listarClientes() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = clientes.mostrar();
        return r;
    }

    @Override
    public Retorno listarVuelos() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = vuelos.mostrar();
        return r;
    }

    // Aplicar recursivamente
    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        Cliente buscado = clientes.obtenerElemento(new Cliente(pasaporte)).getDato();

        if (buscado != null) {
            r.valorString = BuscarVuelosDelCliente(buscado.getVuelosCliente().getInicio(), buscado);
        }

        return r;
    }

    public String BuscarVuelosDelCliente(Nodo<Vuelo> nodo, Cliente cliente) {
        if (nodo == null) {
            return "";
        }
        
        Pasaje buscado = new Pasaje(cliente);
        
        if (nodo.getDato().getPasajesEconVendidos().estaElemento(buscado) || nodo.getDato().getPasajesPClaseVendidos().estaElemento(buscado) 
            || nodo.getDato().getPasajesEconDevueltos().estaElemento(buscado) || nodo.getDato().getPasajesPClasePendientes().estaElemento(buscado)) {
            
            return nodo.getDato().getCodVuelo() + "-CPR|\n" + BuscarVuelosDelCliente(nodo.getSiguiente(), cliente);
        }else if(nodo.getDato().getPasajesEconDevueltos().estaElemento(buscado) || nodo.getDato().getPasajesPClaseDevueltos().estaElemento(buscado)){
            return nodo.getDato().getCodVuelo() + "-DEV|\n" + BuscarVuelosDelCliente(nodo.getSiguiente(), cliente);
        }
        
        return BuscarVuelosDelCliente(nodo.getSiguiente(), cliente);
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
