
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseCreator {

    public void checkIsDatabase() {
        File database = new File("create_db.db");
        boolean exists = database.exists();

        if (!exists) {
            createDatabase(readSqlFile("create_db.sql"));
            insertData(readSqlFile("insert_sample_data.sql"));
        }
    }

    private String readSqlFile(String pathname) {
        String querySql = "";
        File fileSql = new File(pathname);

        try {
            Scanner readLine = new Scanner(fileSql);
           
            while (readLine.hasNext()) {
                querySql += readLine.next() + "\n";

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return querySql;
    }

    private void createDatabase(String querySql) {
        Connection connection;
        Statement statement;

        try {

            connection = DataBaseConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(querySql);
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertData(String querySql) {
        Connection connection;
        Statement statement;

        try {

            connection = DataBaseConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(querySql);
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
