import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class BancoDados {
	public BancoDados(){
		
	}
	
	public Connection ConectaBD(String connectUrl, String user, String senha) {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Connection con = DriverManager.getConnection(connectUrl, user, senha);
			System.out.println("Conexão Realizada com sucesso");

			return con;
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			return null;
		} catch (Exception e){
			System.out.println("Não foi possivel conectar" + e);
			return null;
		}
		
	}
	
	public void CriarTabela(Connection con){
		try{
		String tabela_tipo_produto = 	"CREATE TABLE Tipo_Produto" +
				"(id_tipo int NOT NULL, " +
				"descricao_tipo varchar(100) NOT NULL, " +
				"PRIMARY KEY (id_tipo)) ";
		
		String tabela_produtos = "CREATE TABLE Produtos " +
				"(id_produto int NOT NULL, " +
				"descricao_produto varchar(50) NOT NULL, " +
				"nome_produto varchar(20), " + 
				"preco_produto decimal(10,2), " +
				"PRIMARY KEY (id_produto))"; 
		
		String games = "CREATE TABLE Games" +
		"(game_name varchar(30) NOT NULL, " +
		"memory_required int, " +
		"numero_de_pl int, " +
		"detalhes varchar(30))";
		
		String console = "CREATE TABLE Consoles" +
		"(driver_type varchar(30) NOT NULL, " +
		"size int, " +
		"detalhes_consoles varchar(50)"
				
				;
		
		String acessorios = "";
		
		String customer = "";
		
		String customer_order = "";
		
		String customer_purchases = "";
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(tabela_tipo_produto);
		System.out.println("Tabela Tipo_Produto criada com sucesso");
		
		stmt.executeUpdate(tabela_produtos);
		System.out.println("Tabela Produtos criada com sucesso");
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


/*
 * String sql = "INSERT INTO \"TIPO_PRODUTO\" (id_tipo, descricao_tipo) VALUES (?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, 1);
			stmt.setString(2, "Teste");
			stmt.executeUpdate();
*/


