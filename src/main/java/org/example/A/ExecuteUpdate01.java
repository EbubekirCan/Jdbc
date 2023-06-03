package org.example.A;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");
        Statement st=con.createStatement();

        //ÖRNEK1:developers tablosunda maaşı ortalama maaştan az olanların maaşını ortalama maaş ile güncelleyiniz,
        String sql="UPDATE developers SET salary=(SELECT AVG(salary) FROM developers)"+
                "WHERE salary<(SELECT AVG(salary) FROM developers)";
        // int updated=st.executeUpdate(sql);
        //  System.out.println("Guncellenen kayıt sayisi: "+updated);

        ResultSet rs=st.executeQuery("SELECT id,name,salary FROM developers");
        while (rs.next()){
            System.out.println(rs.getInt("id")+"--"+rs.getString("name")+"--"+rs.getDouble("salary"));
        }

        //ÖRNEK2:developers tablosuna yeni bir developer ekleyiniz.
        String sql2="INSERT INTO developers(name,salary,prog_lang) VALUES('İlker',5300,'React')";
        //  int inserted=st.executeUpdate(sql2);
        //  System.out.println("inserted: "+inserted);

        //ÖRNEK3:developers tablosundan id'si 14 olanı siliniz.
        String sql3="DELETE FROM developers WHERE id=14";
        // int deleted=st.executeUpdate(sql3);
        //  System.out.println("deleted:"+deleted);

        //ÖRNEK4:developers tablosundan prog_lang css olanları siliniz.
        String sql4="DELETE FROM developers WHERE prog_lang ILIKE 'css'";
        // int deletednum= st.executeUpdate(sql4);
        //System.out.println("deleted rows :"+deletednum);

        st.close();
        con.close();
    }
}