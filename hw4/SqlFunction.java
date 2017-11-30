import java.sql.*;

public class SqlFunction {
    void sqlFunction(String inputString) {
        Connection c = null;
        Statement statement = null;
        String query; 
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:chinook.db");
            c.setAutoCommit(false);
            System.out.println("Searching for: " + inputString);

            statement = c.createStatement();
            query = "SELECT ArtistId, Title " +
                    "FROM Album " +
                    "WHERE ArtistId = " +
                    "(SELECT ArtistId " +
                    "FROM Artist " +
                    "WHERE Name = " + "'" +  inputString + "'" + ")";

            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                String Album = resultSet.getString("Title");
                System.out.println(Album);
            }

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
