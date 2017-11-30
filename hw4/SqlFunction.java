import java.sql.*;

public class SqlFunction {
    ResultSet sqlFunction(String query) {
        Connection c = null;
        boolean isEmpty = true;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:chinook.db");
            c.setAutoCommit(false);

            statement = c.createStatement();
            resultSet = statement.executeQuery(query);
            
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return resultSet;
    }
}
