package com.company;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Main {
    //first we need to write mysql query and store it into any variable
    private static final String QUERY = "select * from students";

    public static void main(String[] args) throws SQLException {
        //step 1.Establish the connection of Mysql database
        try(Connection connection = (Connection) getConnection("jdbc:mysql//localhost:3306/jdbc_tech?useSSL=false","root","123456789");

            //step2: create a statement using that above connection object
            Statement stmt = connection.createStatement();
            //step 3: execute the query. there are 2 methods for executing the query. execute() & execute

            ResultSet rs = stmt.executeQuery(QUERY)){
            //step 4: process the result and execute it
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                System.out.println(id+","+name+","+email+","+country);
            }
            connection.close();


        } catch (SQLException e){
                e.printStackTrace();
        }
 }
}
