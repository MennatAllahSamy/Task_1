/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Menna
 */
public class MySqlConnection {

    private static MySqlConnection instance;

    public MySqlConnection() {
    }

    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }

    public Connection connection = null;

    public Connection getConnection() {

        System.out.println("Mysql Testing");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Product", "root", "");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection Error");
        } finally {

            if (connection != null) {
                System.out.println("Connection Success");

            } else {
                System.out.println("Connection Failed!");
            }

        }

        return connection;
    }

}
