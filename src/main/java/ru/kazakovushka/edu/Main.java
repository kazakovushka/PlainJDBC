package ru.kazakovushka.edu;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE Person ( id INTEGER , name VARCHAR)");
            statement.execute("INSERT INTO Person VALUES (0 , 'Tom')");
            statement.execute("INSERT INTO Person VALUES (1 , 'Sara')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");
            while (resultSet.next()){
                System.out.println("pers = " + resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("connection is closed: "+ connection.isClosed());
        }catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }

    }
}
