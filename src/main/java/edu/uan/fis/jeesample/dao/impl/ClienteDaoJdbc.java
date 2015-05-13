package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ClienteDao;
import edu.uan.fis.jeesample.dto.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDaoJdbc implements ClienteDao {

    @Override
    public Cliente create(Cliente cliente) {
         // Sample code
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Tienda;create=false;user=root;password=root");
            // 3. Creates the product in the database
            //stmt = conn.createStatement();
            //stmt.executeUpdate("INSERT INTO PRODUCTS VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
            stmt = conn.prepareStatement("INSERT INTO cliente (usuario, contraseña) VALUES ( ?, ? ) ");
            stmt.setString(1,cliente.getUsuario());
            stmt.setString(2, cliente.getConstraseña());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        // Sample code
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            stmt = conn.prepareStatement("UPDATE cliente SET  contraseña=?  WHERE usuario= ?");  
            stmt.setString(1,cliente.getConstraseña());
            stmt.setString(2,cliente.getUsuario());
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    @Override
    public void delete(Cliente cliente) {
        // Sample code
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement stmt=null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            //stmt = conn.createStatement();
            //stmt.executeUpdate("DELETE FROM PRODUCTS WHERE ID_PRODUCT=" + product.getProductId());
            stmt= conn.prepareStatement("DELETE FROM cliente WHERE usuario = ?");
            stmt.setString(1, cliente.getUsuario());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Cliente findById(String usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Cliente c= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            //stmt =conn.createStatement();
            //stmt.executeUpdate("SELECT * FROM  PRODUCTS WHERE ID_PRODUCT = " + productId.intValue());
            stmt = conn.prepareStatement("SELECT * FROM  cliente WHERE usuario = ?");
            stmt.setString(1, usuario);
            stmt.executeUpdate();    
            rs = stmt.executeQuery();
            while(rs.next()){
            c = new Cliente();
            c.setConstraseña(rs.getString("contraseña"));
            c.setUsuario(rs.getString("usuario"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }

    @Override
    public List<Cliente> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Cliente> c= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            
            stmt = conn.prepareStatement("SELECT * FROM  cliente");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            Cliente ce = new Cliente();
            ce.setUsuario(rs.getString("usuario"));
            ce.setConstraseña(rs.getString("contraseña"));
            c.add(ce);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return  c;
    }
}

