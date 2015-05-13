package edu.uan.fis.jeesample.dao.impl;

//import edu.uan.fis.jeesample.dao.ClienteDao;
import edu.uan.fis.jeesample.dao.OrdencompraDao;
//import edu.uan.fis.jeesample.dto.Cliente;
import edu.uan.fis.jeesample.dto.Ordencompra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrdencompraDaoJdbc implements OrdencompraDao {

    @Override
    public Ordencompra create(Ordencompra orden) {
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
            stmt = conn.prepareStatement("INSERT INTO ordencdompra (Idordencompra, nombre) VALUES ( ?, ?) ");
            stmt.setInt(1, orden.getIdordencompra());
            stmt.setString(2, orden.getNombre());
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
        return orden;
    }

    @Override
    public Ordencompra update(Ordencompra orden) {
      // Sample code
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            stmt = conn.prepareStatement("UPDATE ordencompra SET  nombre =?  WHERE Idordencompra= ?");  
            stmt.setString(1, orden.getNombre());
            stmt.setInt(2, orden.getIdordencompra());
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
        return orden;
    }

    @Override
    public void delete(Ordencompra orden) {
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
            stmt= conn.prepareStatement("DELETE FROM ordencompra WHERE Idordencompra = ?");
            stmt.setInt(1, orden.getIdordencompra());
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
    public Ordencompra findById(Integer IdOrden) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Ordencompra o= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            //stmt =conn.createStatement();
            //stmt.executeUpdate("SELECT * FROM  PRODUCTS WHERE ID_PRODUCT = " + productId.intValue());
            stmt = conn.prepareStatement("SELECT * FROM  ordencompra WHERE Idordencompra= ?");
            stmt.setInt(1, IdOrden);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            
            while(rs.next()){
            o = new Ordencompra();
            o.setIdcompra(rs.getInt("Idordencompra"));
            o.setNombre(rs.getString("nombre"));
                
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
        return o;
    }

    @Override
    public List<Ordencompra> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Ordencompra> o= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda?" + "user=root&password=uan2015$");
            // 3. Creates the product in the database
            
            stmt = conn.prepareStatement("SELECT * FROM ordencompra");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            
            while(rs.next()){
            Ordencompra p = new Ordencompra();
            p.setIdcompra(rs.getInt("Idordencompra"));
            p.setNombre(rs.getString("nombre"));
            o.add(p);
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
        return  o;
    }
}

