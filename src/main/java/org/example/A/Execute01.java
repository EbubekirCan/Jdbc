package org.example.A;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.ADIM:driverı kaydet
        Class.forName("org.postgresql.Driver");//Java7 ile birlikte gerek kalmadı.

        //2.ADIM:Database e bağlanma
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");

        //3.ADIM:Stament oluştur; SQL komutlarını DB ye iletmek ve çalıştırmak için
        Statement st=con.createStatement();

        //System.out.println("Connection success");

        //4.ADIM:Query(sorgu) çalıştırma

        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.

        boolean sql1=st.execute("CREATE TABLE workers(worker_id INT,worker_name VARCHAR(50),salary REAL)");
        System.out.println("sql1: "+sql1);

        //execute():DDL veya DQL için kullanılır
        //DQL için kullanılırsa:ResultSet nesnesi alırsa true döndürür aksi halde false döndürür.
        //DDL için kullanılırsa:geriye False döndürür.


        //ÖRNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sütununu ekleyiniz.
        String query2="ALTER TABLE workers ADD COLUMN city VARCHAR(20)";
        st.execute(query2);

        //ÖRNEK 3:"workers" tablosunu SCHEMAdan siliniz.
        String query3="DROP TABLE workers";
        st.execute(query3);

        //5.ADIM:bağlantı ve statementı kapatma
        st.close();
        con.close();

    }

}