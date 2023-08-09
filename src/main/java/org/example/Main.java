package org.example;

import javax.sql.DataSource;
import java.awt.image.DataBufferUShort;
import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Without Pooling-----------------------------------
//        Connection C = DbConnection.getConnection("web");
//
//        try {
//            if(C==null) {
//                throw new Exception();
//            }
//            String query = "select * from customers";
//            Statement S = C.createStatement();
//            ResultSet rs = S.executeQuery(query);
//
//            while (rs.next())
//            {
//                int id = rs.getInt(1);
//                System.out.println(id);
//            }
//
//        }
//        catch(Exception E)
//        {
//            E.printStackTrace();
//        }
//------------------------------------------------

        DataSource Ds = DbPoolingHikariCP.getDataSource();
        List<Customer> Cl = Customer.generateRandomCustomerList(5);

        try(Connection C = Ds.getConnection())
        {
            Customer.Insert(Cl.get(0),C);
            Customer.getAll(C);
            Customer.delete(2,C);
            System.out.println("After Delete\n");
            Customer.getAll(C);
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }


    }
}