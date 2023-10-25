package jdbcTesting;

import java.sql.*;

public class JDBC_Query01 {

    // siziden bir JDBC sorguu yapanizi istendiginde ilk yapacaginiz gereken is:

    // Database yoneticisinden ilgili database bilgilerini (database access information) almak olamlidir

    /*
        URL : "jbdc:mysql://45.87.83.5/ u168183796_qawonder"
        USERNAME : "u168183796_gawonderuser"
        PASSWORD : "1gvyfx6#Q"
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. adim: kullanilacak veritabani icin dogru surucuyu ekle

         //Class.forName("com.mysql.jdbc.Driver");


        // 2. adim: veritabani ile iletisim baslat
        // URL : "jbdc:mysql://localhost:3306/sys?serverTimezone=UTC","root",'

       Connection connection =  DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qawonder",
                                                             "u168183796_qawonderuser","1gvyfx6#Q");


       // 3. adim: SQL ifadesi olustur ve calistir(Select, Insert/update,delete)



        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        // bir statement olusturabilmek icin MUTLAKA bir connection'inizin olmasi gerekli
        // statement olusturmak bizim sorgumuz icin yeterli olabilir ancak ileride bu statement'i kullanabilmek icin inu bir yere atadik

        // 4. adim: SQl sorgularini calistir ve  gelen sonuclari isle, kaydet vb.

        String query = "SELECT name FROM u168183796_qawonder.staff";

        ResultSet resultSet = statement.executeQuery(query);

        // ResultSet resultSet1 = statement.executeQuery("SELECT name FROM u168183796_qawonder.staff");

        resultSet.next();
        System.out.println(resultSet.getString("name")); // Joe

        resultSet.next();
        System.out.println(resultSet.getString("name")); // Shivam

        resultSet.next();
        System.out.println(resultSet.getString("name")); // Brandon

        resultSet.first();
        System.out.println(resultSet.getString("name")); // Joe

        resultSet.absolute(10);
        System.out.println(resultSet.getString("name")); // JessicaDavis



        // ITERATOR KONUSUNA BAK
    }



}
