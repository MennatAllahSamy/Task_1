/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Driver.MySqlConnection;
import Table.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menna
 */
public class ProductDao {

    public ArrayList<Product> GetAllProducts() {

        String query = "SELECT * FROM `product`";
        MySqlConnection con = MySqlConnection.getInstance();
        Connection connect = con.getConnection();
        Statement statement = null;
        ArrayList<Product> products = new ArrayList<>();
        try {

            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_ID(rs.getInt("Product_ID"));
                product.setType(rs.getString("Type"));
                product.setManufacturer(rs.getString("Manufacturer"));
                product.setProduction_Date(rs.getString("Production_Date"));
                product.setExpiry_Date(rs.getString("Expiry_Date"));

                products.add(product);

            }

        } catch (Exception Ex) {
        } finally {
            try {
                connect.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return products;
    }

    public int InsertProduct(Product product) {
        int affected = 0;

        String sql = "INSERT INTO product (Product_ID, Type, Manufacturer, Production_Date, Expiry_Date) VALUES ('" + product.getProduct_ID() + "', '" + product.getType() + "', '" + product.getManufacturer() + "', '" + product.getProduction_Date() + "', '" + product.getExpiry_Date() + "')";

        Statement statement = null;
        MySqlConnection mc = new MySqlConnection();
        Connection dbConnection = mc.getConnection();
        try {
            statement = dbConnection.createStatement();
            affected = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return affected;
    }

    public int DeleteProduct(Product product) {
        int affected = 0;

        String sql = "DELETE FROM product WHERE Product_ID='" + product.getProduct_ID() + "'";
        Statement statement = null;
        MySqlConnection mc = new MySqlConnection();
        Connection dbConnection = mc.getConnection();
        try {
            statement = dbConnection.createStatement();
            affected = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affected;
    }

    public ArrayList<Product> GetAllManufacturer(Product p) {

        String sql = "select * from product where Manufacturer='" + p.getManufacturer() + "'; ";
        MySqlConnection con = MySqlConnection.getInstance();
        Connection connect = con.getConnection();
        Statement statement = null;
        ArrayList<Product> products = new ArrayList<Product>();
        try {

            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_ID(rs.getInt("Product_ID"));
                product.setType(rs.getString("Type"));
                product.setManufacturer(rs.getString("Manufacturer"));
                product.setProduction_Date(rs.getString("Production_Date"));
                product.setExpiry_Date(rs.getString("Expiry_Date"));
                System.out.print(rs.getInt("Product_ID"));
                products.add(product);

            }
        } catch (Exception Ex) {
        } finally {
            try {
                connect.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return products;
    }

    public int UpdateProduct(Product product, Product oldproduct) {
        int affected = 0;

        String sql = "UPDATE product  SET Product_ID = '" + product.getProduct_ID() + "',Type='" + product.getType() + "',Manufacturer='" + product.getManufacturer() + "',Production_Date='" + product.getProduction_Date() + "',Expiry_Date='" + product.getExpiry_Date() + "' WHERE Product_ID='" + oldproduct.getProduct_ID() + "'";

        Statement statement;
        statement = null;
        MySqlConnection mc = new MySqlConnection();
        Connection dbConnection = mc.getConnection();
        try {
            statement = dbConnection.createStatement();
            affected = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return affected;
    }
}
