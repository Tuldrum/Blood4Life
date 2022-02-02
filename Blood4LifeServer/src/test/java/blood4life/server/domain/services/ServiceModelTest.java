/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;


import blood4life.commons.domain.Assignments;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.UsuarioCliente;
import org.junit.jupiter.api.Test;
import java.sql.Date;  
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ASUS
 */
public class ServiceModelTest {
    
    public ServiceModelTest() {
    }
    
    /**
     * Test of findCita method, of class ServiceModel.
     */
    @Test
    public void testFindCita() {
        System.out.println("findCita");
        int cod_cita = 100;
        ServiceModel instance = new ServiceModel();
        Cita expResult = new Cita(100,10029563,1,Date.valueOf("02-feb-2022"));
        Cita result = instance.findCita(cod_cita);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveCita method, of class ServiceModel.
     */
    @Test
    public void testSaveCita() {
        System.out.println("saveCita");
        Cita cita = null; 
        ServiceModel instance = new ServiceModel();
        String expResult = "";
        String result = instance.saveCita(cita);
        assertEquals(expResult, result);
    }

    /**
     * Test of crearLugarRecogida method, of class ServiceModel.
     */
    @Test
    public void testCrearLugarRecogida() {
        System.out.println("crearLugarRecogida");
        LugarRecogida lugar = null;
        ServiceModel instance = new ServiceModel();
        String expResult = "";
        String result = instance.crearLugarRecogida(lugar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findLugar method, of class ServiceModel.
     */
    @Test
    public void testFindLugar() {
        System.out.println("findLugar");
        int id = 0;
        ServiceModel instance = new ServiceModel();
        LugarRecogida expResult = null;
        LugarRecogida result = instance.findLugar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCustomer method, of class ServiceModel.
     */
    @Test
    public void testCreateCustomer() {
        System.out.println("createCustomer");
        UsuarioCliente customer = null;
        ServiceModel instance = new ServiceModel();
        String expResult = "";
        String result = instance.createCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCustomer method, of class ServiceModel.
     */
    @Test
    public void testFindCustomer() {
        System.out.println("findCustomer");
        int id = 0;
        ServiceModel instance = new ServiceModel();
        UsuarioCliente expResult = null;
        UsuarioCliente result = instance.findCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ServiceModel.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int lugar_id = 0;
        Date fecha = null;
        int sangre_id = 0;
        ServiceModel instance = new ServiceModel();
        Assignments expResult = null;
        Assignments result = instance.find(lugar_id, fecha, sangre_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class ServiceModel.
     */
    @Test
    public void testList() {
        System.out.println("list");
        ServiceModel instance = new ServiceModel();
        List<Assignments> expResult = null;
        List<Assignments> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
