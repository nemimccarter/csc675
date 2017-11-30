import java.sql.*;

public class SqlFunction {
    void sqlFunction(String query) {
        Connection c = null;
        boolean isEmpty = true;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:chinook.db");
            c.setAutoCommit(false);

            statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                isEmpty = false;
                String Album = resultSet.getString("Title");
                System.out.println(Album);
            }
            if (isEmpty) {
                System.out.println("Returned 0 results");
            }

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
