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

    public ListaSimple<Aerolinea> aerolineas; //
    public Cola<Cliente> clientes; //
    public ListaSimple<Vuelo> vuelos;

    public Sistema() {
        aerolineas = new ListaSimple<Aerolinea>();
        vuelos = new ListaSimple<Vuelo>();
        clientes = new Cola<Cliente>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        aerolineas = new ListaSimple<Aerolinea>();
        vuelos = new ListaSimple<Vuelo>();
        clientes = new Cola<Cliente>();
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
        Avion avionDelVuelo = null;

        if (aerolineaDelVuelo != null) {
            avionDelVuelo = aerolineaDelVuelo.getAviones().obtenerElemento(new Avion(codAvion)).getDato();
        }

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

        Resultado ret = null;

        Cliente cliente = clientes.obtenerElemento(new Cliente(pasaporteCliente)).getDato();

        Vuelo vuelo = vuelos.obtenerElemento(new Vuelo(codigoVuelo)).getDato();

        if (cliente == null) {
            ret = ret.ERROR_1;
        } else if (vuelo == null) {
            ret = ret.ERROR_2;
        } else {
            Pasaje pasaje = new Pasaje(cliente, vuelo, categoríaPasaje);
            if (categoríaPasaje == 1) {
                if (vuelo.getCantPasajesEcon() > vuelo.getPasajesEconVendidos().cantElementos()) {
                    vuelo.getPasajesEconVendidos().agregarInicio(pasaje);
                    cliente.getVuelosCliente().encolar(vuelo);
                } else {
                    vuelo.getPasajesEconPendientes().encolar(pasaje);
                }

            } else {
                if (vuelo.getCantPasajesPClase() > vuelo.getPasajesPClaseVendidos().cantElementos()) {
                    vuelo.getPasajesPClaseVendidos().agregarInicio(pasaje);
                    cliente.getVuelosCliente().encolar(vuelo);
                } else {
                    vuelo.getPasajesPClasePendientes().encolar(pasaje);
                }
            }
            ret = ret.OK;
        }
        return new Retorno(ret);
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        Resultado ret = null;

        Cliente cliente = clientes.obtenerElemento(new Cliente(pasaporteCliente)).getDato();

        Vuelo vuelo = vuelos.obtenerElemento(new Vuelo(codigoVuelo)).getDato();
        Pasaje econ = null;
        Pasaje pClase = null;

        if (vuelo != null && cliente != null) {
            econ = vuelo.getPasajesEconVendidos().obtenerElemento(new Pasaje(cliente, vuelo)).getDato();
            pClase = vuelo.getPasajesPClaseVendidos().obtenerElemento(new Pasaje(cliente, vuelo)).getDato();
        }

        if (cliente == null) {
            ret = ret.ERROR_1;
        } else if (vuelo == null) {
            ret = ret.ERROR_2;
        } else if (econ == null && pClase == null) {
            ret = ret.ERROR_3;
        } else {
            cliente.getvuelosDevueltosCliente().encolar(vuelo);
            if (econ != null) {
                vuelo.getPasajesEconDevueltos().agregarInicio(econ);
                vuelo.getPasajesEconVendidos().borrarElemento(econ);
                if (!vuelo.getPasajesEconPendientes().esVacia()) {
                    vuelo.getPasajesEconVendidos().agregarInicio(vuelo.getPasajesEconPendientes().frente());
                    vuelo.getPasajesEconPendientes().desencolar();
                    cliente.getVuelosCliente().encolar(vuelo);
                }
            } else {
                vuelo.getPasajesPClaseDevueltos().agregarInicio(pClase);
                vuelo.getPasajesPClaseVendidos().borrarElemento(pClase);
                if (!vuelo.getPasajesPClasePendientes().esVacia()) {
                    vuelo.getPasajesPClaseVendidos().agregarInicio(vuelo.getPasajesPClasePendientes().frente());
                    vuelo.getPasajesPClasePendientes().desencolar();
                    cliente.getVuelosCliente().encolar(vuelo);
                }
            }
            ret = ret.OK;
        }
        return new Retorno(ret);
    }

    @Override
    public Retorno listarAerolineas() {

        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = aerolineas.mostrar();
        return r;
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre
    ) {

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

        if (buscado != null && buscado.getVuelosCliente() != null) {

            String texto = BuscarVuelosCompradosDelCliente(buscado.getVuelosCliente().getInicio(), buscado) + BuscarVuelosDevueltosDelCliente(buscado.getvuelosDevueltosCliente().getInicio(), buscado);
            r.valorString = texto.substring(0, texto.length() - 1);
        }

        return r;
    }

    public String BuscarVuelosCompradosDelCliente(Nodo<Vuelo> nodo, Cliente cliente) {
        if (nodo == null) {
            return "";
        }

        return BuscarVuelosCompradosDelCliente(nodo.getSiguiente(), cliente) + nodo.getDato().getCodVuelo() + "-CPR|\n";
    }

    public String BuscarVuelosDevueltosDelCliente(Nodo<Vuelo> nodo, Cliente cliente) {
        if (nodo == null) {
            return "";
        }

        return BuscarVuelosDevueltosDelCliente(nodo.getSiguiente(), cliente) + nodo.getDato().getCodVuelo() + "-DEV|\n";

    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Aerolinea aerolinea = aerolineas.obtenerElemento(new Aerolinea(nombreAerolinea)).getDato();

        if (aerolinea == null) {
            r = Retorno.error1();
        } else {
            r = Retorno.ok();

            r.valorString = "";

            Nodo<Vuelo> nodo = vuelos.getInicio();

            for (int i = 0; i < vuelos.cantElementos() - 1; i++) {

                if (nodo.getDato().getAerolinea().getNombre() == nombreAerolinea) {
                    if (!nodo.getDato().getPasajesPClaseDevueltos().esVacia()) {
                        r.valorString += nodo.getDato().getPasajesPClaseDevueltos().mostrar() + "\n";
                    }
                    if (!nodo.getDato().getPasajesEconDevueltos().esVacia()) {
                        r.valorString += nodo.getDato().getPasajesEconDevueltos().mostrar() + "\n";
                    }
                }
                nodo = nodo.getSiguiente();
            }
            r.valorString = r.valorString.substring(0, r.valorString.length() - 1);

        }
        return r;
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {

        Retorno r = new Retorno(Retorno.Resultado.OK);

        Vuelo vuelo = vuelos.obtenerElemento(new Vuelo(codigoVuelo)).getDato();

        String econ[][] = new String[vuelo.getCantPasajesEcon() / 3][3];
        String pClase[][] = new String[vuelo.getCantPasajesPClase() / 3][3];

        ListaSimple<Pasaje> pasajesEco = vuelo.getPasajesEconVendidos();

        ListaSimple<Pasaje> pasajesPClase = vuelo.getPasajesPClaseVendidos();

        for (int i = 0; i < econ.length; i++) {
            for (int j = 0; j < econ[i].length; j++) {
                if (!pasajesEco.esVacia()) {
                    econ[i][j] = pasajesEco.getInicio().getDato().getCliente().getPasaporte();
                    pasajesEco.borrarInicio();
                } else {
                    econ[i][j] = "XXXXXXXX";
                }
            }
        }
        for (int i = 0; i < pClase.length; i++) {
            for (int j = 0; j < pClase[i].length; j++) {
                if (!pasajesPClase.esVacia()) {
                    pClase[i][j] = pasajesPClase.getInicio().getDato().getCliente().getPasaporte();
                    pasajesPClase.borrarInicio();
                } else {
                    pClase[i][j] = "XXXXXXXX";
                }
            }
        }
        String vistaVuelo = "**********************************\\n\\t*\\tPRIMERA\\t*\\t\\n";

        for (int i = 0; i < pClase.length; i++) {
            vistaVuelo += "**********************************\\n";
            for (int j = 0; j < pClase[i].length; j++) {
                vistaVuelo += "* " + pClase[i][j] + " ";
            }
            vistaVuelo += "\\t*\\n";
        }
        vistaVuelo += "**********************************\\n\\t*\\tECONÓMICA\\t*\\t\\n";
        for (int i = 0; i < econ.length; i++) {
            vistaVuelo += "**********************************\\n";
            for (int j = 0; j < econ[i].length; j++) {
                vistaVuelo += "* " + econ[i][j] + " ";
            }
            vistaVuelo += "\\t*\\n";
        }
        vistaVuelo += "**********************************";
        r.valorString = vistaVuelo;
        return r;
    }
}
