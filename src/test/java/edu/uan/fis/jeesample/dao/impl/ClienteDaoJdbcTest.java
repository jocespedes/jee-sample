package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Cliente;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class ClienteDaoJdbcTest extends TestCase {
    
    public ClienteDaoJdbcTest(String testName) {
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
        Cliente cliente = new Cliente();
        cliente.setUsuario("Jorge");
        cliente.setConstraseña("123");
        
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        Cliente expResult = cliente;
        Cliente result = instance.create(cliente);
        assertEquals(expResult, result);
    }

    public void testUpdate() {
        System.out.println("update");
        Cliente cliente = new Cliente("Bibiana","Vero");
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        Cliente expResult = cliente;
        Cliente result = instance.update(cliente);       
        assertEquals(expResult, result);  

    }

    public void testDelete() {
        System.out.println("delete");
        Cliente cliente = new Cliente("Freddy");
        cliente.getUsuario();
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        instance.delete(cliente);    
    }

    public void testFindById() {
        System.out.println("findById");
        String contraseña = "123";
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        Cliente expResult = null;
        Cliente result = instance.findById(contraseña);
        assertEquals(expResult, result);
        
        
    }

    public void testFindAll() {
        System.out.println("findAll");
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
       
    }
}

