package ch.vehicles.tbz;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleService {

    Connection connection;

    public VehicleService(Connection connection) {
        this.connection = connection;
    }

    public void showCashRegister() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM cash_register");
        System.out.println(rs.getBigDecimal("amount"));
    }

}
