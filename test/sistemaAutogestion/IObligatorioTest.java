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
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        Retorno r = miSistema.eliminarAerolinea("Avianca");
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
        Retorno r = miSistema.eliminarAvion("Avianca", "AAA123");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR1() {
        Retorno r = miSistema.eliminarAvion("JJ", "AAA123");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR2() {
        Retorno r = miSistema.eliminarAvion("Avianca", "AA323A123");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    //@Test
    //public void testEliminarAvionERROR3() {
    //    Retorno r= miSistema.eliminarAvion("Avianca", "AAA123");
    //    assertEquals(Retorno.error3().resultado, r.resultado);
    //}
    @Test
    public void testRegistrarCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testCrearVuelo() {
        //Completar para segunda entrega
    }

    @Test
    public void testComprarPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testDevolverPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testListarAerolineasOK() {
        Retorno r = miSistema.listarAerolineas();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testListarAvionesDeAerolineaOK() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Delta");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAvionesDeAerolinea("Avianca");
        assertEquals(Retorno.ok().resultado, r.resultado);
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
        //Completar para segunda entrega
    }

    @Test
    public void testListarVuelos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVuelosDeCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testPasajesDevueltos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVistaDeVuelo() {
        //Completar para segunda entrega
    }

}
