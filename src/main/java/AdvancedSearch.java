import java.sql.*;

public class AdvancedSearch {

    public void searchAllTables(String searchPhrase) {

        Connection connection;

        try {
            connection =  DataBaseConnection.getConnection();

            String selectSQL = String.format("SELECT * FROM customers\n" +
                    "inner join sales on customers.id = sales.customer_id\n" +
                    "WHERE customers.id like '%1$s' or name like '%1$s' or surname like '%1$s' or\n" +
                    "birthyear like '%1$s' or gender like '%1$s' or product_name like '%1$s' or\n" +
                    "net_value like '%1$s' or tax_rate like '%1$s' order by customers.id", "%" + searchPhrase + "%");

//            String selectSQL = "SELECT * FROM customers WHERE  customers.surname like ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
//            preparedStatement.setString(1, "%" + searchPhrase + "%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer customerId = rs.getInt("id");

                String customerName = rs.getString("name");
                customerName = customerName.replaceAll("\n", "\\s+");

                String customerSurname = rs.getString("surname");
                customerSurname = customerSurname.replaceAll("\\n", "\\s ");

                Integer customerBirthYear = rs.getInt("birthyear");
                String customerGender = rs.getString("gender");

                String productName = rs.getString("product_name");
                productName = productName.replaceAll("\\n", "\\s ");
                productName = productName.replaceAll(" -s", "");

                Double netVaue = rs.getDouble("net_value");
                Integer taxRate = rs.getInt("tax_rate");

                System.out.println(customerId + ", " + customerName + ", " + customerSurname + ", " +
                        customerBirthYear + ", " + customerGender + ", " + productName + ", " +
                        netVaue + ", " + taxRate);
            }
            System.out.println("---------------------------------------------------------------------\n");

            preparedStatement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

}