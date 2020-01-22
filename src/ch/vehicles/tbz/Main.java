package ch.vehicles.tbz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  public static int sort;

  public static void main(String[] args) throws SQLException {

    String entry = "";
    JdbcConnection jdbcConnection = new JdbcConnection("jdbc:postgresql://localhost:5432/car_salesman", "postgres", "123");

    Connection connection = jdbcConnection.createConnection();
    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM cash_register");
    System.out.println(rs.getBigDecimal("amount"));
    VehicleController vehicleController = new VehicleController(connection);

    if(connection != null){
      do{
        entry = vehicleController.showMenu();
        vehicleController.switchCase(entry);
      }while(!"x".equals(entry.toLowerCase()));
    }

  }
}
