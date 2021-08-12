import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	// Fornecer uma api de conexão com o banco de dados específico MYSQL
	  private static String dbUrl = "jdbc:mysql://localhost:3306/curso";
	  private static String dbUser = "root";
	  private static String dbPass = "";

	  // M�todo para obter conex�o f�sica com o banco dados (MYSQL)
	  public static Connection getConnect() throws SQLException {

	    // Trata a exce��o de ClassNotFound
	    try {

	     
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    }

	    catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }

	    return DriverManager.getConnection(dbUrl, dbUser, dbPass);
	  }
}
