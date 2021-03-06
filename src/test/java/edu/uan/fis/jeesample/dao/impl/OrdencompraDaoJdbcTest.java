package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Ordencompra;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class OrdencompraDaoJdbcTest extends TestCase {
    
    public OrdencompraDaoJdbcTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        System.out.println("create");
        Ordencompra orden = new Ordencompra();
        orden.setIdcompra(1);
        orden.setNombre("Carpe");
        
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        Ordencompra expResult = orden;
        Ordencompra result = instance.create(orden);
        assertEquals(expResult, result);
    }

    public void testUpdate() {
        System.out.println("update");
        Ordencompra cliente = new Ordencompra("Diem",2);
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        Ordencompra expResult = cliente;
        Ordencompra result = instance.update(cliente);       
        assertEquals(expResult, result);  

    }

    public void testDelete() {
        System.out.println("delete");
        Ordencompra orden = new Ordencompra(5);
        orden.getIdordencompra();
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        instance.delete(orden);    
    }

    public void testFindById() {
        System.out.println("findById");
        Integer IdOrden = 1;
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        Ordencompra expResult = null;
        Ordencompra result = instance.findById(IdOrden);
        assertEquals(expResult, result);
        
        
    }

    public void testFindAll() {
        System.out.println("findAll");
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
       
    }
}

