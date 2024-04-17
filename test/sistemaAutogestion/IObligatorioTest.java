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
        miSistema.crearAerolinea("Volaris", "Mexico", 5);
        miSistema.crearAerolinea("Avianca", "Colombia", 8);
        miSistema.registrarAvion("AAA123",20,"Avianca");
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
        r = miSistema.crearAerolinea("Aerolinea Argentina", "Argentina", 8);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 18);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panama", 15);
        assertEquals(Retorno.ok().resultado, r.resultado);
    
    }
    
      @Test
    public void testCrearAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Latam", "Chile", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("VivaAerobus", "Mexico", -1);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }
    
       @Test
    public void testCrearAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Delta", "Uruguay", 5);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Volaris", "Estados Unidos", 6);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        Retorno r = miSistema.eliminarAerolinea("Delta");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Volaris");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    
    // @Test
    //public void testEliminarAerolineaERROR1() {
    //    Retorno r = miSistema.eliminarAerolinea("Air Europa");
    //    assertEquals(Retorno.error1().resultado, r.resultado);
    //}
    
    @Test
    public void testEliminarAerolineaERROR2() {
        Retorno r = miSistema.eliminarAerolinea("Avianca");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }
    
    @Test
    public void testRegistrarAvion() {
        //Completar para primera entrega
    }

    @Test
    public void testEliminarAvion() {
        //Completar para primera entrega
    }

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
    public void testListarAerolineas() {
        //Completar para primera entrega
    }

    @Test
    public void testListarAvionesDeAerolinea() {
        //Completar para primera entrega
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
