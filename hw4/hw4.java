import java.util.Scanner;
import java.sql.*;

public class hw4 {

    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int userChoice;
        boolean isEmpty = true;
        String inputString = "",
               query = "";
        boolean runProgram = true;
        ResultSet results = null; 
        SqlFunction sqlObject = new SqlFunction();

        while (runProgram) {
            results = null;
            isEmpty = true;
            query = "";
            inputString = "";

            System.out.println("Select an option:\n" +
                "0. Exit\n" +
                "1. Obtain Album title by Artist name\n" +
                "3. Obtain purchase history of customer\n" +
                "4. Update track price by track ID\n");
            userChoice = in.nextInt();
            in.nextLine();

            switch (userChoice) {
                case (0) :
                    System.out.println("Goodbye\n");
                    runProgram = false;                
                    break;

                case (1) :
                    System.out.println("Enter Artist name: ");
                    inputString = in.nextLine();
                    query = "SELECT ArtistId, Title " +
                            "FROM Album " +
                            "WHERE ArtistId = " +
                            "(SELECT ArtistId " +
                            "FROM Artist " +
                            "WHERE Name = " + "'" +  inputString + "'" + ")";
                    results = sqlObject.sqlFunction(query);

                    try {
                        while (results.next()) {
                            isEmpty = false;
                            String title = results.getString("Title");
                            System.out.println(title);
                        }
            
                        if (isEmpty) {
                            System.out.println("Returned 0 results");
                        }
                    } catch ( Exception e ) {
                        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                        System.exit(0);
                    }


                    break;

                case (3) :
                    System.out.println("Enter customer ID: ");
                    inputString = in.nextLine();

                    query = "SELECT Track.Name, A.Title, IL.Quantity, I.InvoiceDate " +
                            "FROM Track, Album A, InvoiceLine IL, Invoice I " +
                            "WHERE Track.AlbumId = A.AlbumId " +
                            "AND IL.InvoiceId = I.InvoiceId " +
                            "AND I.CustomerId = " + '"' + inputString + '"';
                    results = sqlObject.sqlFunction(query);
                    try {
                        while (results.next()) {
                            isEmpty = false;
                            String trackName = results.getString("Name"),
                                   albumTitle = results.getString("Title"),
                                   quantity = results.getString("Quantity"),
                                   date = results.getString("InvoiceDate"); 
                            System.out.println(trackName + " | " + albumTitle + " | " + quantity + " | " + date);
                        }
                        if (isEmpty) {
                            System.out.println("Returned 0 results");
                        }
                    } catch ( Exception e ) {
                        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                        System.exit(0);
                    }


                    break;

                case (4) :

                    break;

                default:
                    System.out.println("Error: Please make a valid selection.\n");
                    break;
            }
        }
    }
}
