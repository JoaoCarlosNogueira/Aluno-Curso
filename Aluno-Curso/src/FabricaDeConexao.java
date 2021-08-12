import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	// Fornecer uma api de conexÃ£o com o banco de dados especÃ­fico MYSQL
	  private static String dbUrl = "jdbc:mysql://localhost:3306/curso";
	  private static String dbUser = "root";
	  private static String dbPass = "";

	  // Método para obter conexão física com o banco dados (MYSQL)
	  public static Connection getConnect() throws SQLException {

	    // Trata a exceção de ClassNotFound
	    try {

	     
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    }

	    catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }

	    return DriverManager.getConnection(dbUrl, dbUser, dbPass);
	  }
}
