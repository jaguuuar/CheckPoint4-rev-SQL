import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        App app = new App();
        Scanner scanner = new Scanner(System.in);
        Boolean appON = true;

        DataBaseCreator dataBaseCreator = new DataBaseCreator();
        dataBaseCreator.checkIsDatabase();
        DataBaseConnection.getConnection();

        while (appON) {
            String searchPhrase = app.searchPhrase(scanner);
            AdvancedSearch advancedSearch = new AdvancedSearch();
            advancedSearch.searchAllTables(searchPhrase);
            if(searchPhrase.equals("q")){
                appON = false;
            }
        }
        scanner.close();
        DataBaseConnection.closeConnection();

    }

    public String searchPhrase(Scanner scanner) {

        System.out.print("Enter phrase : ");
        String searchPhrase = scanner.next();

        return searchPhrase;
    }


}
