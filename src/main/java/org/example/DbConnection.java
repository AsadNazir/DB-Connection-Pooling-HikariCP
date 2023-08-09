package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    static final String Url ="jdbc:mysql://localhost:3306";
    static final String username = "root";
    static final String password = "root";
    public static Connection getConnection(String DbName)
    {
        Connection C = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            C = DriverManager.getConnection(Url+"/"+DbName,username,password);
            System.out.println("Connection Established");
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        return C;
    }

}
