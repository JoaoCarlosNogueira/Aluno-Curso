import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AlunoDAO {
	 private static Connection con = null;

	  // Api para Preparar sentenças SQL
	  private static PreparedStatement pstm = null;

	  // Mantem uma coleção de dados do banco
	  private static ResultSet rs = null;

	 
	  private static void startConPstm(String sql) throws SQLException {

	    con = FabricaDeConexao.getConnect();
	    pstm = con.prepareStatement(sql);
	  }

	  // Fecha o pstm e a conexão
	  private static void closeConPstm(Connection con, PreparedStatement pstm) {

	    // Tratamento de exceção
	    try {
	      pstm.close();
	      con.close();
	    }

	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	 
	  private static void closeConPstmRs(Connection con, PreparedStatement pstm, ResultSet rs) {

	    // Tratamento de exceção
	    try {
	      rs.close();
	      pstm.close();
	      con.close();
	    }

	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  
	
	  
	  public static boolean save(Curso<Aluno> curso) {

	    boolean sucess = false;

	    String sqlInsert = "INSERT INTO Aluno SET id, nome, disciplina, nota) VALUES(?, ?, ?, ?)";

	    String sqlUpdate = "UPDATE Aluno SET id=?, nome?, disciplina=?, nota=? WHERE id=?";

	    for (Aluno aluno : curso.getItemList()) {

	      // Tratamento de exceção
	      try {

		if (aluno.getId() == 0) {

		  startConPstm(sqlInsert);

		}

		else {


		  startConPstm(sqlUpdate);

		  pstm.setInt(5, aluno.getId());

		}

		pstm.setInt(1, aluno.getId());
		pstm.setString(2, aluno.getNome());
		pstm.setString(3, aluno.getDisciplina());
		pstm.setFloat(4, aluno.getNota());

	  // retorna zero se não for modificado
		sucess = pstm.executeUpdate() > 0;
	      }

	      catch (SQLException e) {
		e.printStackTrace();
	      }

	      finally {
		closeConPstm(con, pstm);
	      }

	    }

	    return sucess;

	  } 
	  
	  
	  public static boolean salvarAluno(Aluno aluno) {

		    boolean sucess = false;

		    String sqlInsert = "INSERT INTO Aluno SET id, nome, disciplina, nota) VALUES(?, ?, ?, ?)";

		    String sqlUpdate = "UPDATE Aluno SET id=?, nome?, disciplina=?, nota=? WHERE id=?";

		   

		      // Tratamento de exceção
		      try {

			if (aluno.getId() == 0) {

			  startConPstm(sqlInsert);

			}

			else {


			  startConPstm(sqlUpdate);

			  pstm.setInt(5, aluno.getId());

			}

			pstm.setInt(1, aluno.getId());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getDisciplina());
			pstm.setFloat(4, aluno.getNota());

		  // retorna zero se não for modificado
			sucess = pstm.executeUpdate() > 0;
		      }

		      catch (SQLException e) {
			e.printStackTrace();
		      }

		      finally {
			closeConPstm(con, pstm);
		      }

		    

		    return sucess;

		  }
	  



	  public static Curso<Aluno> getCurso() {

	    String sqlSelect = "SELECT * FROM aluno";

	    Curso<Aluno> curso = new Curso<Aluno>();

	    // Tratamento de exceção
	    try {

	      startConPstm(sqlSelect);

	      rs = pstm.executeQuery();

	      while (rs.next()) {

		Aluno aluno = new Aluno();

		aluno.setId(rs.getInt("id"));
		aluno.setNome(rs.getString("nome"));
		aluno.setDisciplina(rs.getString("disciplina"));
		aluno.setNota(rs.getInt("nota"));
		

		curso.add(aluno);
	      }
	    }

	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    finally {
	      closeConPstmRs(con, pstm, rs);
	    }

	    return curso;
	  }

	  public static void deleteAlunoById(int id) {

	    String sqlDelete = "DELETE FROM aluno WHERE id=?";

	    // Tratamento de exceção
	    try {


	      startConPstm(sqlDelete);

	      pstm.setInt(1, id);
	      pstm.execute();
	    }

	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    finally {
	      closeConPstm(con, pstm);
	    }
	  }

	  public static Aluno getAlunoById(int id) {

	    Aluno aluno = null;

	    String sql = "SELECT * FROM aluno WHERE id=?";

	    // Tratamento de exceção
	    try {

	    
	      startConPstm(sql);

	      pstm.setInt(1, id);
	      rs = pstm.executeQuery();

	      if (rs.next()) {

		Aluno aluno1 = new Aluno();

	    aluno1.setId(rs.getInt("id"));
		aluno1.setNome(rs.getString("nome"));
		aluno1.setDisciplina(rs.getString("disciplina"));
		aluno1.setNota(rs.getFloat("nota"));


	      }
	    }

	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    finally {
	      closeConPstmRs(con, pstm, rs);
	    }

	    return aluno;
	  }


}
