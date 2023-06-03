package org.example.A;

import java.sql.*;

public class Tekrar2 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");
        Statement st = con.createStatement();


//        String sql="CREATE TABLE tekrarTABLE(id int not null,name varchar(20) unique,lastname varchar(20),age int,salary real)";
//
//       boolean isTrue= st.execute(sql);
//        System.out.println(isTrue);
//
//        String sqlprp="INSERT INTO tekrartable VALUES(?,?,?,?,?)";
//
//       PreparedStatement asd= con.prepareStatement(sqlprp);
//       asd.setInt(1,10);
//       asd.setString(2,"Ahmet");
//       asd.setString(3,"selim");
//       asd.setInt(4,32);
//       asd.setDouble(5,5000.4);
//
//      int updated= asd.executeUpdate();
//        System.out.println(updated);

//
//        String sqlprp2="SELECT * FROM tekrartable ";
//       PreparedStatement asd2= con.prepareStatement(sqlprp2);
//      ResultSet asd3= asd2.executeQuery();
//      if (asd3.next()){
//          System.out.println(asd3.getString("id")+asd3.getString("name")+
//                  asd3.getString("lastname")+asd3.getString("age")+asd3.getString("salary"));
//
//      }
//
//      String asdas="DELETE from tekrartable where id=10";
//     int upd= st.executeUpdate(asdas);
//
     String asds="DROP TABLE tekrartable";
    int asda2s= st.executeUpdate(asds);

    st.close();
    con.close();

    }
}
