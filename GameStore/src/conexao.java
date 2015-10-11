import java.sql.*;
import java.sql.JDBCType;


public class conexao {
	public static void ConectaBD(String user, String senha) {
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" 
		+ "databaseName=GAMESTORE";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Connection con = DriverManager.getConnection(connectionUrl, user, senha);
			System.out.println("Conexão Realizada com sucesso");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("SQLeError: " + ex.getErrorCode());
		} catch (Exception e){
			System.out.println("Não foi possivel conectar" + e);
		}
		
	}
}
