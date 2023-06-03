package org.example.A;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        //Database e bağlanma
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");

        //Stament oluştur; SQL komutlarını DB ye iletmek ve çalıştırmak için
        Statement st=con.createStatement();

        //System.out.println("Connection success");

        //Query(sorgu) çalıştırma

        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        String query1="SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10";
        boolean sql1=st.execute(query1);
        System.out.println("sql1 :"+sql1);

        //kayıtları görmek için executeQuery() kullanmalıyız.
        ResultSet resultSet=st.executeQuery(query1);
        //resultSet.next();
        //System.out.println(resultSet.getString("country_name"));
        while (resultSet.next()){
            System.out.println("Ülke ismi: "+resultSet.getString("country_name"));
            // System.out.println(resultSet.getString(1));
        }

        //Resultset'in first(),last(),next() gibi metodları vardır.
        //Resultset'te geriye dönüş yoktur.

        System.out.println("------------ÖRNEK2-------------");

        //ÖRNEK 2: phone_code'u 600 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz.
        String query2="SELECT phone_code,country_name FROM countries WHERE phone_code>600";
        ResultSet rs2=st.executeQuery(query2);

        while (rs2.next()){
            System.out.println(rs2.getInt("phone_code")+"--"+rs2.getString("country_name"));
        }

        System.out.println("------------ÖRNEK3-------------");

        //ÖRNEK 3:developers tablosunda "salary" değeri en düşük salary olan developerların tüm bilgilerini gösteriniz.

        String query3="SELECT * FROM developers WHERE salary=(SELECT min(salary) FROM developers)";
        ResultSet rs3=st.executeQuery(query3);

        while (rs3.next()){
            System.out.println(rs3.getInt("id")+"--"+rs3.getString("name")+"--"+
                    rs3.getDouble("salary")+"--"+rs3.getString("prog_lang"));
        }

        System.out.println("------------ÖRNEK4-------------");
        //ÖRNEK 4:Puanı bölümlerin taban puanlarının ortalamasından yüksek olan öğrencilerin isim ve puanlarını listeleyiniz.

        String query4="SELECT isim,puan FROM ogrenciler WHERE puan>(SELECT AVG(taban_puanı) FROM bolumler)";
        ResultSet rs4=st.executeQuery(query4);

        while (rs4.next()){
            System.out.println(rs4.getString("isim")+"--"+rs4.getInt("puan"));
        }

        st.close();
        con.close();
    }
}