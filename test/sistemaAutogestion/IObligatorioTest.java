/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pesce
 */
public class IObligatorioTest {

    private Sistema miSistema;

    public IObligatorioTest() {
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();

        miSistema.crearAerolinea("Delta", "Estados Unidos", 2);
        miSistema.crearAerolinea("Volaris", "Mexico", 8);
        miSistema.crearAerolinea("Avianca", "Colombia", 5);

        miSistema.registrarAvion("AAA123", 21, "Avianca");
        miSistema.registrarAvion("AAA123", 9, "Delta");
        miSistema.registrarAvion("AAA125", 21, "Delta");

        miSistema.registrarCliente("A1B2C3D", "Lucas Giusiano", 23);
        miSistema.registrarCliente("X4Y5Z6A", "Santiago Mieres", 30);
        miSistema.registrarCliente("B7C8D9E", "Federico Perez", 56);

        miSistema.crearVuelo("ALT123", "Avianca", "AAA123", "España", 20, 5, 2024, 12, 3);
        miSistema.crearVuelo("ALT1234", "Delta", "AAA123", "Francia", 20, 5, 2024, 6, 3);
        miSistema.crearVuelo("ALT1235", "Avianca", "AAA123", "Italia", 25, 5, 2024, 15, 6);

        miSistema.comprarPasaje("A1B2C3D", "ALT123", 1);
        miSistema.comprarPasaje("A1B2C3D", "ALT1234", 2);

        miSistema.comprarPasaje("X4Y5Z6A", "ALT123", 2);
        miSistema.comprarPasaje("X4Y5Z6A", "ALT1234", 1);

        miSistema.comprarPasaje("B7C8D9E", "ALT123", 2);

        miSistema.devolverPasaje("A1B2C3D", "ALT123");
        
        miSistema.devolverPasaje("X4Y5Z6A", "ALT1234");
        
        miSistema.devolverPasaje("B7C8D9E", "ALT123");

    }

    @Test
    public void testCrearSistemaDeGestion() {

        Retorno r = miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaOK() {

        Retorno r = miSistema.crearAerolinea("Gol", "Brasil", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentina", "Argentina", 8);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 18);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panama", 15);
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testCrearAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Delta", "Uruguay", 5);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Volaris", "Estados Unidos", 6);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Avianca", "China", 20);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Latam", "Chile", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("VivaAerobus", "Mexico", -1);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        Retorno r = miSistema.eliminarAerolinea("Volaris");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR1() {
        Retorno r = miSistema.eliminarAerolinea("Air Europa");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("UX");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        Retorno r = miSistema.eliminarAerolinea("Avianca");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Delta");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOK() {
        Retorno r = miSistema.registrarAvion("AAA312", 9, "Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AAB123", 24, "Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AAB12RR", 27, "Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AAEB123", 30, "Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AAA125", 30, "Volaris");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR1() {
        Retorno r = miSistema.registrarAvion("AAA123", 15, "Avianca");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.registrarAvion("AAA123", 9, "Delta");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR2() {
        Retorno r = miSistema.registrarAvion("AACA312", 8, "Volaris");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("AACB123", 25, "Volaris");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR3() {
        Retorno r = miSistema.registrarAvion("AAA312", 9, "Tap Airlines");
        assertEquals(Retorno.error3().resultado, r.resultado);
        r = miSistema.registrarAvion("AAB123", 24, "Air Europa");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR4() {
        Retorno r = miSistema.registrarAvion("AAA31223", 9, "Delta");
        assertEquals(Retorno.error4().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionOK() {
        Retorno r = miSistema.eliminarAvion("Delta", "AAA125");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR1() {
        Retorno r = miSistema.eliminarAvion("JJ", "AAA123");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR2() {
        Retorno r = miSistema.eliminarAvion("Avianca", "AA323A12das3");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR3() {
        Retorno r = miSistema.eliminarAvion("Avianca", "AAA123");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testRegistrarClienteOK() {
        Retorno r = miSistema.registrarCliente("F1G2H3I", "Rels B", 25);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarClienteERROR1() {
        Retorno r = miSistema.registrarCliente("F1G2H3I", "Rels BS", -1);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarClienteERROR2() {
        Retorno r = miSistema.registrarCliente("1G2H3I", "Rels BA", 50);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarCliente("1G2H3IAA", "Rels B", 60);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloOK() {
        Retorno r = miSistema.crearVuelo("ALT1DA23", "Delta", "AAA123", "Francia", 20, 7, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("ALT1DADA23", "Delta", "AAA123", "España", 19, 8, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR1() {
        Retorno r = miSistema.crearVuelo("ALT123", "Delta", "AAA123", "Francia", 20, 7, 2024, 6, 3);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR2() {
        Retorno r = miSistema.crearVuelo("ALT12SDD3", "Copas", "AAA123", "Francia", 20, 7, 2024, 6, 3);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR3() {
        Retorno r = miSistema.crearVuelo("ALT1FASF23", "Delta", "AAA1dda23", "Francia", 20, 7, 2024, 6, 3);
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    public void testCrearVueloERROR4() {
        Retorno r = miSistema.crearVuelo("ALTDADS123", "Avianca", "AAA123", "Italia", 20, 5, 2024, 15, 6);
        assertEquals(Retorno.error4().resultado, r.resultado);
    }

    public void testCrearVueloERROR5() {
        Retorno r = miSistema.crearVuelo("ALTDADS123", "Avianca", "AAA123", "Italia", 25, 6, 2024, 14, 6);
        assertEquals(Retorno.error5().resultado, r.resultado);
        r = miSistema.crearVuelo("ALTDADS123", "Avianca", "AAA123", "Italia", 25, 6, 2024, 15, 7);
        assertEquals(Retorno.error5().resultado, r.resultado);
        r = miSistema.crearVuelo("ALTDADS123", "Avianca", "AAA123", "Italia", 25, 6, 2024, 16, 5);
        assertEquals(Retorno.error5().resultado, r.resultado);
    }

    public void testCrearVueloERROR6() {
        Retorno r = miSistema.crearVuelo("ALTDADS123", "Avianca", "AAA123", "Italia", 25, 6, 2024, 15, 9);
        assertEquals(Retorno.error6().resultado, r.resultado);
    }

    @Test
    public void testComprarPasajeOK() {
        Retorno r = miSistema.comprarPasaje("A1B2C3D", "ALT123", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    public void testComprarPasajeERRO1() {
        Retorno r = miSistema.comprarPasaje("A1B2CDASD3D", "ALT123", 1);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    public void testComprarERROR2() {
        Retorno r = miSistema.comprarPasaje("A1B2C3D", "ALT12DAS3", 1);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeOK() {
        Retorno r = miSistema.devolverPasaje("X4Y5Z6A", "ALT123");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeERROR1() {
        Retorno r = miSistema.devolverPasaje("X4YAS5Z6A", "ALT1234");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeERROR2() {
        Retorno r = miSistema.devolverPasaje("X4Y5Z6A", "ALT1234DAS");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeERROR3() {
        Retorno r = miSistema.devolverPasaje("X4Y5Z6A", "ALT1235");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testListarAerolineasOK() {
        Retorno r = miSistema.listarAerolineas();
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAerolineas();
        assertEquals("Avianca-Colombia-5|\nDelta-Estados Unidos-2|\nVolaris-Mexico-8|", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolineaOK() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Delta");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAvionesDeAerolinea("Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAvionesDeAerolinea("Delta");
        assertEquals("AAA125-21|\nAAA123-9|", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolineaERROR1() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Air Europa");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.listarAvionesDeAerolinea("Tal Airlines");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testListarClientes() {
        Retorno r = miSistema.listarClientes();
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("B7C8D9E-Federico Perez-56|\nX4Y5Z6A-Santiago Mieres-30|\nA1B2C3D-Lucas Giusiano-23|", r.valorString);
    }

    @Test
    public void testListarVuelos() {
        Retorno r = miSistema.listarVuelos();
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("ALT123-Avianca-AAA123-0-1-20|\nALT1234-Delta-AAA123-0-1-8|\nALT1235-Avianca-AAA123-0-0-21|", r.valorString);
    }

    @Test
    public void testVuelosDeCliente() {
        Retorno r = miSistema.vuelosDeCliente("A1B2C3D");
        assertEquals(Retorno.ok().resultado, r.resultado);
        assertEquals("ALT1234-CPR|\nALT123-CPR|\nALT123-DEV|", r.valorString);
    }

    @Test
    public void testPasajesDevueltosOK() {
        Retorno r = miSistema.pasajesDevueltos("Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.pasajesDevueltos("Avianca");
        assertEquals("B7C8D9E-ALT123|\nA1B2C3D-ALT123|", r.valorString);
    }
    
    
    @Test
    public void testPasajesDevueltosERROR1() {
        Retorno r = miSistema.pasajesDevueltos("Plata");
        assertEquals(Retorno.error1().resultado, r.resultado);
        
    }

    @Test
    public void testVistaDeVuelo() {
        Retorno r = miSistema.vistaDeVuelo("ALT123");
        assertEquals("B7C8D9E-ALT123|\nX4Y5Z6A-ALT1234|", r.valorString);
    }

}
