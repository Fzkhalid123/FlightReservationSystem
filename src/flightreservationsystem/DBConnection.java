package flightreservationsystem;

import java.sql.*;

public class DBConnection {

    Connection c;
    Statement s;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///flightreservationsystem", "root", "Frazer2025");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





